/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DomainClasses;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author MK
 */
public interface GeneralDObject {

    String getAtrValue();

    String setAtrValue();

    String getClassName();

    String getWhereCondition();

    String getNameByColumn(int column);

    GeneralDObject getNewRecord(ResultSet rs) throws SQLException;
}
