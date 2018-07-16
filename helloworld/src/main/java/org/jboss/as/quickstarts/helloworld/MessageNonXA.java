package org.jboss.as.quickstarts.helloworld;


import javax.persistence.*;

@Entity
@Table(name = "MESSAGENONXA")
public class MessageNonXA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "messagenonxa", nullable = false)
    private String messagenonxa;

    public MessageNonXA(){}

    public MessageNonXA(String messagenonxa) {
        this.messagenonxa = messagenonxa;
    }

    public String getMessage() {
        return messagenonxa;
    }

    public void setMessage(String messagenonxa) {
        this.messagenonxa = messagenonxa;
    }

    @Override
    public String toString() {
        return "messagenonxa{" +
                "messagenonxa='" + messagenonxa + '\'' +
                '}';
    }
}
