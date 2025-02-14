package com.omelenko.films.film;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

import java.util.Objects;

public class Film implements Parcelable {
    private final int id;
    private final String title;
    private final String director;
    private final String genre;
    private final int releaseYear;
    private final double rating;

    public Film(int id, String title, String director, String genre, int releaseYear, double rating) {
        this.id = id;
        this.title = title;
        this.director = director;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
    }

    protected Film(Parcel in) {
        id = in.readInt();
        title = in.readString();
        director = in.readString();
        genre = in.readString();
        releaseYear = in.readInt();
        rating = in.readDouble();
    }

    public static final Creator<Film> CREATOR = new Creator<Film>() {
        @Override
        public Film createFromParcel(Parcel in) {
            return new Film(in);
        }

        @Override
        public Film[] newArray(int size) {
            return new Film[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(@NonNull Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(title);
        dest.writeString(director);
        dest.writeString(genre);
        dest.writeInt(releaseYear);
        dest.writeDouble(rating);
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getDirector() {
        return director;
    }

    public String getReleaseYear() {
        return String.valueOf(releaseYear);
    }

    public String getRating() {
        return String.valueOf(rating);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return getId() == film.getId() && Objects.equals(getReleaseYear(), film.getReleaseYear()) && Objects.equals(this.getRating(), film.getRating()) && Objects.equals(getTitle(), film.getTitle()) && Objects.equals(getDirector(), film.getDirector()) && Objects.equals(getGenre(), film.getGenre());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getTitle(), getDirector(), getGenre(), getReleaseYear(), getRating());
    }
}
