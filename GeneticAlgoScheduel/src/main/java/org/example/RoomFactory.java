package org.example;

import comm.Room;

import java.util.ArrayList;

public class RoomFactory {
    private Integer size;
    private ArrayList<String> roomNumber;
    private ArrayList<Integer> capacities;

    public RoomFactory (Integer size, ArrayList<String> roomNumber, ArrayList<Integer> capacities){
        if (size != roomNumber.size() && size != capacities.size()) {
            throw new IllegalArgumentException("roomNumber size needs to match capacities size");
        }
        else{
            this.roomNumber = roomNumber;
            this.capacities = capacities;
            this.size = size;
        }
    }
    public ArrayList<Room> createRooms(){
        ArrayList<Room> returnRoom = new ArrayList<Room>(size);
        for (int i = 0; i < size; i++){
            Room room = new Room(roomNumber.get(i), capacities.get(i));
            returnRoom.add(room);
        }
        return returnRoom;
    }
}
