package com.kmitsystem.tools.interfaces;

/**
 * E-Mail Interface
 *
 * @author Malte
 */
public interface EmailInterface {

    public int port = 465;
    public String host = "smtp.example.com";
    public String from = "info@leago.com";
    public boolean auth = true;
    public String username = "";
    public String password = "";
    public Protocol protocol = Protocol.SMTPS;

    public enum Protocol {

        SMTP,
        SMTPS,
        TLS
    }

    /**
     * E-Mail Interface
     *
     * @param to Mail-Empfänger
     * @param subject Mail-Betreff
     * @param body Mail-Text
     */
    public void sendEmail(String to, String subject, String body);

}
