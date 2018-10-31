package dao;

import model.BaseModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public abstract class BaseDAOImpl<ENTITY extends BaseModel> implements  BaseDAO<ENTITY> {


    private final String selectAllQuery = "Select *  from ".concat(getTableName());

    @Inject
    Database datasource;


    @Override
    public void populate(ResultSet rs, ENTITY entity) throws SQLException {

        if (entity != null) {
            if (rs.getObject("id") != null) {
                entity.setId(rs.getInt("id"));
            }

        }

    }


    @Override
    public List<ENTITY> selectAll() throws SQLException {

        Connection conn = null;
        List<ENTITY> list = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            conn = datasource.getConnection();
            ps = conn.prepareStatement(selectAllQuery);
            ENTITY entity = null;
            rs = ps.executeQuery();
            list = new ArrayList<ENTITY>();

            while (rs.next()) {
                entity = getEntityInstance();
                populate(rs, entity);
                list.add(entity);
            }

        } finally {
            close(conn, ps, rs);
        }
        return list;
    }



    /**
     * Close all resources in the database
     *
     *
     * @param conn
     * @param ps
     * @param rs
     */
    protected void close(Connection conn, PreparedStatement ps, ResultSet rs) {

        close(rs);
        close(ps);
        close(conn);
    }

    /**
     * Close all resources in the database
     *
     * @param ps
     * @param rs
     */
    protected void close(PreparedStatement ps, ResultSet rs) {

        close(rs);
        close(ps);

    }

    /**
     * Close database connection
     *
     * @param conn
     */
    protected void close(Connection conn) {

        if (conn != null) {
            try {
                conn.close();
                conn = null;
            } catch (SQLException e) {
            }
        }

    }

    /**
     * Close database preparement statement
     *
     * @param ps
     */
    protected void close(PreparedStatement ps) {

        if (ps != null) {
            try {
                ps.close();
                ps = null;
            } catch (SQLException e) {
            }
        }

    }


}
