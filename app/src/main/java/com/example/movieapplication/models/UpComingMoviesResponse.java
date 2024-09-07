package com.example.movieapplication.models;

import java.util.ArrayList;

public class UpComingMoviesResponse {

    public boolean status;
    public long timestamp;
    public ArrayList<Message> message;
    public class Entry{
        public String id;
        public String titleText;
        public TitleType titleType;
        public ImageModel imageModel;
        public String releaseDate;
        public ArrayList<String> genres;
        public ArrayList<PrincipalCredit> principalCredits;
        public ReleaseYear releaseYear;
    }

    public class ImageModel{
        public String url;
        public int maxHeight;
        public int maxWidth;
        public String caption;
    }

    public class Message{
        public String group;
        public ArrayList<Entry> entries;
    }

    public class PrincipalCredit{
        public String id;
        public String text;
    }

    public class ReleaseYear{
        public int year;
    }

    public class TitleType{
        public String id;
        public String text;
        public boolean canHaveEpisodes;
    }
}
