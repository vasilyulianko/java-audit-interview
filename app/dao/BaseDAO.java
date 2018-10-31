package dao;

import model.BaseModel;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface BaseDAO<ENTITY extends BaseModel> {


    /**
     * Define the columns of the table for query building purposes
     *
     * @return String array with the columns name
     */
    public  String[] getTableDefinition();


    /**
     * Method to insert an entity into a table
     * @param entity entity to insert
     * @return true in succsess false if error
     * @throws SQLException if an SQL error happens
     */
    public  boolean insert(ENTITY entity) throws SQLException;

    /**
     * Populate and entity reading from database
     * @param rs
     * @param entity
     */
    public  void populate(ResultSet rs, ENTITY entity) throws SQLException;

    /**
     * Define the name of the record that will be used in the DAO
     *
     * @return Table name
     */
    public String getTableName();

    /**
     * Create an instance of the Model class
     *
     * @return Model class extendin of BaseModel
     */
    public ENTITY getEntityInstance();


    /**
     * Create a list of entities reading from DB
     * @return List of entities
     * @throws SQLException in an error at db level happens
     */
    public List<ENTITY> selectAll() throws  SQLException;


}
