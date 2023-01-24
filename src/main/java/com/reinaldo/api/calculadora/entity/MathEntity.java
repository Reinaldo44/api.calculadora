package com.reinaldo.api.calculadora.entity;

import com.reinaldo.api.calculadora.exceptions.UnsupportedMathOperationException;
import org.springframework.beans.factory.annotation.Autowired;

public class MathEntity {

    @Autowired
    UnsupportedMathOperationException unsupported;
    public Double sum(String numberOne, String numberTwo ){

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){

            throw unsupported;
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    public Double sub(String numberOne, String numberTwo){

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){

            throw unsupported;
        }

        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }
    public Double div(String numberOne, String numberTwo){

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){

            throw unsupported;
        }

        return convertToDouble(numberOne) / convertToDouble(numberTwo);
    }

    public Double mult(String numberOne, String numberTwo){

        if(!isNumeric(numberOne) || !isNumeric(numberTwo)){
            
            throw unsupported;
        }

        return convertToDouble(numberOne) * convertToDouble(numberTwo);

    }

    private Double convertToDouble(String strNumber) {
        if(strNumber == null) return 0D;
        String number = strNumber.replaceAll(",", ".");
        if(isNumeric(number)) return Double.parseDouble(number);
        return 0D;

    }

    private boolean isNumeric(String strNumber) {
        if(strNumber == null) return false;
        String number = strNumber.replaceAll(",", ".");
        return number.matches("[-+]?[0-9]*\\.?[0-9]+");
    }
}
