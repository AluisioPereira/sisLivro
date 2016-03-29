
package br.com.sislivros.factory;

/**
 *
 * @author Zilderlan
 */
public class DaoFactory {
    public static DaoFactoryIF createFactory(){
        return new DaoFactoryBD();
    }
    
}
