package ru.clevertec.clevertec_final.security.utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Utility class for JWT token handling and validation.
 */
@Slf4j
public class JwtTokenUtil {

    private static final String jwtSecret = "IwANTtObECOMEaDEVELOPERIwANTtObECOMEaDEVELOPERIW";

    /**
     * Validate a JWT token.
     *
     * @param token The JWT token to validate.
     * @return True if the token is valid, false otherwise.
     * @throws IllegalArgumentException if the token is invalid or expired.
     */
    public static boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token);
            return true;
        } catch (SignatureException ex) {
            log.info("SignatureException");
            throw new IllegalArgumentException("Exception indicating that either calculating a signature or verifying an existing signature of a JWT failed.");
        } catch (MalformedJwtException ex) {
            log.info("MalformedJwtException");
            throw new IllegalArgumentException("Exception indicating that a JWT was not correctly constructed and should be rejected.");
        } catch (ExpiredJwtException ex) {
            log.info("ExpiredJwtException");
            throw new IllegalArgumentException("Exception indicating that a JWT was accepted after it expired and must be rejected.");
        } catch (UnsupportedJwtException ex) {
            log.info("UnsupportedJwtException");
            throw new IllegalArgumentException("Exception thrown when receiving a JWT in a particular format/configuration that does not match the format expected by the application.");
        } catch (IllegalArgumentException ex) {
            log.info("IllegalArgumentException");
            throw new IllegalArgumentException("IllegalArgumentException JWT");
        }
    }
}
