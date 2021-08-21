package com.promineo.ryanleyva1;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AlbumDao {

    private Connection connection;

    private final String READ_ALL_ALBUMS_QUERY = "SELECT * FROM albums";
    private final String CREATE_NEW_ALBUM_QUERY = "INSERT INTO albums(name, artist) VALUES(?, ?)";
    private final String DELETE_ALBUM_BY_ID_QUERY = "DELETE FROM albums WHERE id = ?";
    private final String UPDATE_ALBUM_BY_ID = "UPDATE albums SET name = ?, artist = ? WHERE id = ?";
    public AlbumDao(){
        connection = DBConnection.getConnection();
    }

    public List<Album> getAlbums() throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(READ_ALL_ALBUMS_QUERY);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Album> albums = new ArrayList<Album>();

        while(resultSet.next()){
            albums.add(new Album(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3)));
        }

        return albums;

    }

    public void createAlbum(String name, String artist) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(CREATE_NEW_ALBUM_QUERY);
        preparedStatement.setString(1, name);
        preparedStatement.setString(2, artist);
        preparedStatement.executeUpdate();
        System.out.println("Record inserted!");
    }

    public void updateAlbumById(String name, String artist, int id) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ALBUM_BY_ID);
        preparedStatement.setString(1,name);
        preparedStatement.setString(2, artist);
        preparedStatement.setInt(3, id);
        preparedStatement.executeUpdate();
        System.out.println("Record updated!");
    }

    public void deleteAlbumById(int id) throws SQLException{
        PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ALBUM_BY_ID_QUERY);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        System.out.println("Record deleted!");
    }

}
