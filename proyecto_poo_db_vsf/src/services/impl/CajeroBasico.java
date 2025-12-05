package services.impl;

import DAO.CuentaDAO;
import DAO.MovimientoDAO;
import DTO.CuentaTarjetaDTO;
import constants.Mensajes;
import exception.AccountNotExistException;
import exception.InsufficientBalanceException;
import exception.UnderMinimunException;
import exception.WrongNipException;
import models.Atm;
import models.Cuenta;
import models.Movimiento;
import models.Ticket;
import services.OpBasicas;

import java.time.LocalDate;

public class CajeroBasico extends Atm implements OpBasicas {

    private CuentaDAO cuentaDAO = new CuentaDAO();
    private MovimientoDAO movimientoDAO = new MovimientoDAO();

    private int cajeroId;

    public CajeroBasico(String ubicacion, int folioOperacio, int cajeroId) {
        super(ubicacion, folioOperacio);
        this.cajeroId = cajeroId;
    }
    //Busca unicamente sobre los datos tal cual esten en la tabla cuentas
    //no concidera
    @Override
    public Cuenta buscarCuenta(int numCuenta) {

        Cuenta aux = null;
        //buscando la cuenta
        for(Cuenta c : this.getCuentas()){
            if(c.getNumCuenta() == numCuenta){
                aux = c;
                break;
            }
        }
        return aux;
    }

    @Override
    public void consultarSaldo(long numTarjeta) {
        CuentaTarjetaDTO cuenta = null;
        cuenta =  cuentaDAO.buscarCuenta(numTarjeta);

        if (cuenta!=null){
            System.out.println("El saldo disponible es: "+cuenta.getSaldo());
        }else{
            System.out.println("No existe una cuenta asociada a esa tarjeta");
        }
    }


    @Override
    public Object[] retirar(long numTarjeta, String nip, int monto)
            throws AccountNotExistException, WrongNipException, InsufficientBalanceException, UnderMinimunException {
        Object[] data = new Object[2];//Objeto de salida [dinero,ticket]
        CuentaTarjetaDTO cuenta = null;
        Ticket ticket = null;
        cuenta = cuentaDAO.buscarCuenta(numTarjeta);
        //System.out.println(">>>>>>>>>>>>>>>>>>>"+cuenta);
        if (cuenta==null){
            //System.out.println("No existe la cuenta asociada a la tarjeta: ");
            throw new AccountNotExistException(Mensajes.CUENTA_NO_EXISTE);
        } else if (!(cuenta.getNip().equals(nip))) {//valida el nip
            //System.out.println("NIP incorrecto");
            throw new WrongNipException(Mensajes.NIP_INCORRECTO);
        }else if (cuenta.getSaldo()<monto){
            //System.out.println("Saldo insuficiente");
            throw new InsufficientBalanceException(Mensajes.SALDO_INSUFICIENTE);
        } else if (  (cuenta.getSaldo() - monto) < cuenta.getSaldoMin()  ) {
            //System.out.println("Retiro no disponle, quedaria por debajo del minimo");
            throw new UnderMinimunException(Mensajes.BAJO_EL_MINIMO);
        }else{
            //retiro
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo()-monto);
            this.setFolioOperacio(this.getFolioOperacio()+1);//actualizar el folio de operacion
            //registrar movimiento
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(),
                    "RETIRO",monto);
            movimientoDAO.registrarMovimineto(m);
            //construir el ticket
            ticket = new Ticket(this.cajeroId, this.getFolioOperacio(), this.getUbicacion(),
                    LocalDate.now(), cuenta.getNumCuenta(), "RETIRO", monto);
            data[0] = monto;
            data[1] = ticket;
        }
        return data;
    }

    //Al crear excepciones, hay 2 caminos
    //Crear una excepcion individual por cada error/evento del flujo que quieres expresar
    //Crear una sola clase de excepcion que maneje todos los errores de noegocio
}
