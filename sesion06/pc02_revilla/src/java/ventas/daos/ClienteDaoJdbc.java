/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ventas.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import ventas.entidades.ClienteTO;
import ventas.entidades.VendedorTO;
import ventas.servicios.ClienteService;
import ventas.servicios.EntidadService;
import ventas.servicios.VendedorService;
import ventas.util.DBConn;

/**
 *
 * @author Alumno-CT
 */
public class ClienteDaoJdbc implements ClienteService<ClienteTO> {
    
    private Connection cn;
    private PreparedStatement pst;
    private ResultSet rs;
    
    @Override
    public ClienteTO validar(String us, String ps) {
        ClienteTO vendedor = null;
        if (us.contentEquals(ps)) {
            try {
                String sql = "select*from tb_cliente where ruc_cli=?";
                cn = DBConn.getConnection();
                pst = cn.prepareStatement(sql);
                pst.setString(1, us);
                rs = pst.executeQuery();
                if (rs.next()) {
                    vendedor = new ClienteTO();
                    vendedor.setCod_cli(rs.getString(1));
                    vendedor.setRaz_soc_cli(rs.getString(2));
                    vendedor.setDir_cli(rs.getString(3));
                    vendedor.setTel_cli(rs.getString(4));
                    vendedor.setRuc_cli(rs.getString(5));
                    vendedor.setCod_dis(rs.getString(6));
                    vendedor.setFec_reg(rs.getDate(7));
                    vendedor.setTip_cli(rs.getString(8));
                    vendedor.setContacto(rs.getString(8));
                }
                
                rs.close();
                pst.close();
                cn.close();
            } catch (SQLException ex) {
                System.out.println("Error:" + ex.getMessage());
            }
        }
        return vendedor;
    }
    
}
