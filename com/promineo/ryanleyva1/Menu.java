package com.promineo.ryanleyva1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    AlbumDao albumDao = new AlbumDao();

    public void start(){
        String response = "";

        do{
            this.printMenu();
            response = scanner.nextLine();
            if(response.equals("")) {

                response = scanner.nextLine();
            }

            int result = Integer.parseInt(response);
            try {

            switch(result){
                case 1: //Create
                    createAlbum();
                    break;

                case 2:
                    updateAlbum();
                    break;

                case 3: // Read
                    readAlbums();
                    break;

                case 4: // Delete
                    deleteAlbum();
                    break;

            }
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }while(!response.equals("-1"));
    }

    private void printMenu(){
        System.out.println("Please select an option:");
        System.out.println("1. " + "Create an album");
        System.out.println("2. " + "Update an album");
        System.out.println("3. " + "Read all albums");
        System.out.println("4. " + "Delete album by Id");
    }

    private void createAlbum() throws SQLException {
        printRequestMessage("name");
        String name = scanner.nextLine();
        printRequestMessage("artist");
        String artist = scanner.nextLine();
        albumDao.createAlbum(name, artist);
    }

    private void updateAlbum() throws SQLException{
        printRequestMessage("Id");
        int id = scanner.nextInt();
        printRequestMessage("name");
        String name = scanner.nextLine();
        printRequestMessage("artist");
        String artist = scanner.nextLine();
        albumDao.updateAlbumById(name, artist, id);
    }

    private void printRequestMessage(String s){
        System.out.println("Enter the " + s + " of the album:");
    }

    private void readAlbums() throws SQLException {
        List<Album> albums = albumDao.getAlbums();
        for(Album album : albums){
            System.out.println("ID: "+ album.getAlbumId() + " Name: " + album.getName() + " Artist: " + album.getArtist() );
        }
    }

    private void deleteAlbum()throws SQLException{
        printRequestMessage("Id");
        int id = scanner.nextInt();
        albumDao.deleteAlbumById(id);
    }


}
