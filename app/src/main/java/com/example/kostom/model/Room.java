package com.example.kostom.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Room implements Parcelable {
    private String size;
    private Boolean hasBathroom, hasAC, hasTable, hasChair, hasWardrobe, hasTV;
    public Room(String size, Boolean hasBathroom, Boolean hasAC, Boolean hasTable, Boolean hasChair, Boolean hasWardrobe, Boolean hasTV) {
        this.size = size;
        this.hasBathroom = hasBathroom;
        this.hasAC = hasAC;
        this.hasTable = hasTable;
        this.hasChair = hasChair;
        this.hasWardrobe = hasWardrobe;
        this.hasTV = hasTV;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Boolean getHasBathroom() {
        return hasBathroom;
    }

    public void setHasBathroom(Boolean hasBathroom) {
        this.hasBathroom = hasBathroom;
    }

    public Boolean getHasAC() {
        return hasAC;
    }

    public void setHasAC(Boolean hasAC) {
        this.hasAC = hasAC;
    }

    public Boolean getHasTable() {
        return hasTable;
    }

    public void setHasTable(Boolean hasTable) {
        this.hasTable = hasTable;
    }

    public Boolean getHasChair() {
        return hasChair;
    }

    public void setHasChair(Boolean hasChair) {
        this.hasChair = hasChair;
    }

    public Boolean getHasWardrobe() {
        return hasWardrobe;
    }

    public void setHasWardrobe(Boolean hasWardrobe) {
        this.hasWardrobe = hasWardrobe;
    }

    public Boolean getHasTV() {
        return hasTV;
    }

    public void setHasTV(Boolean hasTV) {
        this.hasTV = hasTV;
    }

    protected Room(Parcel in) {
        size = in.readString();
        hasBathroom = in.readByte() != 0;
        hasAC = in.readByte() != 0;
        hasTable = in.readByte() != 0;
        hasChair = in.readByte() != 0;
        hasWardrobe = in.readByte() != 0;
        hasTV = in.readByte() != 0;
    }

    public static final Creator<Room> CREATOR = new Creator<Room>() {
        @Override
        public Room createFromParcel(Parcel in) {
            return new Room(in);
        }

        @Override
        public Room[] newArray(int size) {
            return new Room[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(size);
        dest.writeByte((byte) (hasBathroom ? 1 : 0));
        dest.writeByte((byte) (hasAC ? 1 : 0));
        dest.writeByte((byte) (hasTable ? 1 : 0));
        dest.writeByte((byte) (hasChair ? 1 : 0));
        dest.writeByte((byte) (hasWardrobe ? 1 : 0));
        dest.writeByte((byte) (hasTV ? 1 : 0));
    }
}
