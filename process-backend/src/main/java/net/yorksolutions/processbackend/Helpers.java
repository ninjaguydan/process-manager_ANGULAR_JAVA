package net.yorksolutions.processbackend;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import javax.xml.bind.DatatypeConverter;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Objects;
import java.util.Optional;

public class Helpers {

    public static <T> T emptyCheck(Optional<T> item) {
        if (item.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.I_AM_A_TEAPOT);
        }
        return item.get();
    }
    public static void presenceCheck(Optional item) {
        if (item.isPresent()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
    public static <T> T nullCheck(T value){
        if (value == null || value == "") {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        } else {
            return value;
        }
    }
    public static void checkValues(String[] values){
        for (int i = 0; i < values.length; i++){
            if ( Objects.equals(values[i], "") || values[i] == null) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }
        }
    }
    public static String textToMd5(String text) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("MD5");
        messageDigest.update(text.getBytes());
        byte[] digest = messageDigest.digest();
        return DatatypeConverter.printHexBinary(digest).toLowerCase();
    }
}