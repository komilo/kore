/*
 * Ms-Backup est une libraire de sauvegarde et de restauration de base de données.
réaliser par AGOTSI Komi Gédéonm Etudiant en deuxième année a l'IAI-TOGO.
 */
package tg.komilo.kore.service;

import java.io.Serializable;
import javax.ejb.Remote;
import tg.komilo.kore.utils.BackupConfiguration;

/**
 *
 * @author gedCommit
 */
@Remote
public interface BackupServiceBeanRemote extends Serializable {
    
    /**
     * Sauvegarde la source de données liée à l'EntityManager principale de l'application.
     * @param configuration
     */
    void backup(BackupConfiguration configuration);
    /**
     * Restauration la source de données liée à l'EntityManager principale de l'application
     * @param configuration 
     */
    void restore(BackupConfiguration configuration);  
    
    
}
