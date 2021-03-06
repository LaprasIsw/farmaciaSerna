/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.itson.farmacia.Implementacion;

import mx.itson.farmacia.Entidades.HibernateUtil;
import java.util.List;
import javax.swing.JOptionPane;
import mx.itson.farmacia.Entidades.DerechoHabiente;
import mx.itson.farmacia.Entidades.Doctor;
import mx.itson.farmacia.Interfaz.DerechoHabienteInterfaz;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author blabla
 */
public class IDerechoHabiente implements DerechoHabienteInterfaz{
    
    @Override
    public void agregarDerechoHabiente(DerechoHabiente dh){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        try{
            tx = session.beginTransaction();
            session.save(dh);
            tx.commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null,"Ah ocurrido un problema al agregar"
                    + "un derechoHabiente.");
        }finally{
            session.close();
        }
    }
    
    @Override
    public List<Doctor> mostrarDerechoHabientes(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = null;
        List<Doctor> lista= null;
        try{
            tx = session.beginTransaction();
            String hql = "FROM DerechoHabiente";
            Query query = session.createQuery(hql);
            lista = query.list();
            tx.commit();
        }catch(Exception ex){
            JOptionPane.showMessageDialog(null, "Ah ocurrido un problema al"
                    + "mostrar los datos de derechoHabiente.");
        }finally{
            session.close();
        }
        return lista;
    }
}
