package org.jboss.as.quickstarts.helloworld;


import javax.persistence.*;

@Entity
@Table(name = "MESSAGEXA")
public class MessageXA {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private int id;

    @Column(name = "messagexa", nullable = false)
    private String messagexa;

    public MessageXA(){}

    public MessageXA(String messagexa) {
        this.messagexa = messagexa;
    }

    public String getMessage() {
        return messagexa;
    }

    public void setMessage(String messagexa) {
        this.messagexa = messagexa;
    }

    @Override
    public String toString() {
        return "MessageXA{" +
                "MessageXA='" + messagexa + '\'' +
                '}';
    }
}
