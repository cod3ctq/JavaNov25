package Services.impl;

import DAO.CuentaDAO;
import DAO.MovimientoDAO;
import DTO.CuentaTarjetaDTO;
import Models.Atm;
import Models.Cuenta;
import Models.Movimiento;
import Models.Ticket;
import Services.OpBasicas;

import java.time.LocalDate;

public class CajeroBasico extends Atm implements OpBasicas {

    private CuentaDAO cuentaDAO =  new CuentaDAO();
    private MovimientoDAO movimientoDAO= new MovimientoDAO();

    private int cajeroId;
    public CajeroBasico(String ubicacion, int folioOperacion, int cajeroId) {
        super(ubicacion, folioOperacion);
        this.cajeroId = cajeroId;
    }
     //Busca unicamente sobre los datos tal cual esten de la tabla CUENTAS
    //No considera la relacion de la tabla TARJETAS
    @Override
    public Cuenta buscarCuenta(int numCuenta) {
        Cuenta aux=null;
        //Buscando la cuenta
        for(Cuenta c : this.getCuentas()) {
            if(c.getNumCuenta()==numCuenta) {
               aux=c;
               break;
            }
        }
        return aux;
    }

    @Override
    public void consultarSaldo(long numTarjeta) {
        CuentaTarjetaDTO cuenta = null;
        cuenta=cuentaDAO.buscarCuenta(numTarjeta);

        if (cuenta!=null) {
            System.out.println("El saldo disponible es: " + cuenta.getSaldo());
        }else{
            System.out.println("No existe una cuenta asociada a esa tarjeta. ");
        }
    }

    @Override
    public Object[] retirar(long numTarjeta, String nip, int monto)
            throws AccountNoExistException, WrongNipException, InsufficientBalanceException, UnderMinimunException {
        //Buscaqueda: validar si existe
        Object[] data = new Object[2]; //objeto de salida
        CuentaTarjetaDTO cuenta=null;
        Ticket ticket=null;
        cuenta=cuentaDAO.buscarCuenta(numTarjeta);

        if (cuenta==null){ //si no existe la cuenta
            throw new AccountNoExistException(Mensajes.CUENTA_NO_EXISTE);
        } else if ( !(cuenta.getNip().equals(nip))) {
            throw new WrongNipException(Mensajes.NIP_INCORRECTO);
        }else if (cuenta.getSaldo()<monto){
            throw new InsufficientBalanceException(Mensajes.SALDO_INSUFICIENTE);
        } else if ((cuenta.getSaldo()-monto)<cuenta.getSaldoMin()) {
            throw new UnderMinimunException(Mensajes.BAJO_EL_MINIMO);
        }else{
           //retiro
            cuentaDAO.actualizarSaldo(cuenta.getNumCuenta(), cuenta.getSaldo()-monto);
            this.setFolioOperacion(this.getFolioOperacion() + 1);
            Movimiento m = new Movimiento(cuenta.getCuentaId(), LocalDate.now(),"RETIRO",monto);
            movimientoDAO.registrarMovimiento(m);
            //actualiza el folio de operacion
           //construir el ticket
            ticket= new Ticket(this.cajeroId, this.getFolioOperacion(),
                    this.getUbicacion(), LocalDate.now(), cuenta.getNumCuenta(),
                    "RETIRO", monto);
            data[0]= monto;
            data[1]= ticket;
        }
        //Validar el nip
        //Que me alcance:saldoDisponible < monto
        //Que no quede por abajo del minimo: saldoDisponible - monto > minimo
        //retiro

        //saldo, numCuenta,

        return  data;

        //al crerar excepciones, hay 2 caminos
        //Crear una excepcion individual por cada evento del flujo que quieras expresar
        //
    }

}
