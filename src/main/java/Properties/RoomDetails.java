package Properties;

public class RoomDetails {
    String roomType;
    Integer roomSqFt;
    String floorType;
    Integer floorNoWhereRoomLocated;

    public String getRoomType(){
        return roomType;
    }
    public void setRoomType(String  roomType){
        this.roomType = roomType;
    }
    public Integer getRoomSqFt(){
        return roomSqFt;
    }
    public void setRoomSqFt(Integer roomSqFt){
        this.roomSqFt = roomSqFt;
    }
    public String getFloorType(){
        return floorType;
    }
    public void setFloorType(String floorType){
        this.floorType = floorType;
    }
    public Integer getFloorNoWhereRoomLocated(){
        return floorNoWhereRoomLocated;
    }
    public void setFloorNoWhereRoomLocated(Integer floorNoWhereRoomLocated){
        this.floorNoWhereRoomLocated = floorNoWhereRoomLocated;
    }
}
