/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AbstractProductB;

import DomainClasses.GeneralDObject;
import java.util.concurrent.atomic.AtomicInteger;

/**
 *
 * @author MK
 */
public abstract class BrokerBazePodataka {

    public abstract boolean makeConnection();

    public abstract boolean insertRecord(GeneralDObject odo);

    public abstract boolean updateRecord(GeneralDObject odo, GeneralDObject odoold);

    public abstract boolean updateRecord(GeneralDObject odo);

    public abstract boolean deleteRecord(GeneralDObject odo);

    public abstract GeneralDObject findRecord(GeneralDObject odo);

    public abstract boolean commitTransation();

    public abstract boolean rollbackTransation();

    public abstract boolean getCounter(GeneralDObject odo, AtomicInteger counter);

    public abstract boolean increaseCounter(GeneralDObject odo, AtomicInteger counter);

    public abstract void closeConnection();
}
