package org.jboss.as.quickstarts.helloworld;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.lang.invoke.MethodHandles;
import java.util.List;
import java.util.logging.Logger;

@Transactional
@ApplicationScoped
public class Persistence {

    private final Logger log = Logger.getLogger(MethodHandles.lookup().lookupClass().getName());

    @PersistenceContext(unitName = "rhpam-nonxa")
    private EntityManager rhpamnonxa;

    @PersistenceContext(unitName = "rhpam-xa")
    private EntityManager rhpamxa;


    public void persistNonXA(MessageNonXA messageNonXA) {
        log.info("persisting messageNonXA [ " + messageNonXA.toString() + "] on NONXA datasource");
        rhpamnonxa.persist(messageNonXA);
        rhpamnonxa.flush();
    }

    public void persistXA(MessageXA messageXA) {
        log.info("persisting messageNonXA [ " + messageXA.toString() + "] on XA datasource");
        rhpamxa.persist(messageXA);
        rhpamxa.flush();
    }

    public List<MessageNonXA> nonXaMessages() {
        Query query = rhpamnonxa.createQuery("SELECT e FROM MessageNonXA e");
        return (List<MessageNonXA>) query.getResultList();
    }

    public List<MessageXA> xaMessages() {
        Query query = rhpamxa.createQuery("SELECT e FROM MessageXA e");
        return (List<MessageXA>) query.getResultList();
    }

}