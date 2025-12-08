package services;

import exceptions.AccountNotExistException;
import exceptions.InsufficientBalanceException;
import exceptions.UnderMinimunException;
import exceptions.WrongNipException;

public interface OpBasicas {
    Object[] retirar(long numTarjeta, String nip, int monto)
            throws AccountNotExistException,
            WrongNipException,
            InsufficientBalanceException,
            UnderMinimunException;
}
