package com.example.movieapplication.models;

import java.util.ArrayList;

public class StreamingMoviesResponse {

    public boolean status;
    public String message;
    public long timestamp;
    public ArrayList<Datum> data;
    public class CanRateTitle{
        public boolean isRatable;
    }

    public class Category{
        public String id;
        public String text;
        public String value;
    }

    public class Datum{
        public String providerName;
        public ArrayList<Edge> edges;
    }

    public class DisplayableProperty{
        public Value value;
    }

    public class Edge{
        public Title title;
    }

    public class OriginalTitleText{
        public String text;
    }

    public class PrimaryImage{
        public String id;
        public String imageUrl;
        public int imageWidth;
        public int imageHeight;
    }

    public class RatingsSummary{
        public double aggregateRating;
        public TopRanking topRanking;
        public int voteCount;
    }

    public class ReleaseYear{
        public int year;
        public int endYear;
    }

    public class Title{
        public String id;
        public boolean isAdult;
        public CanRateTitle canRateTitle;
        public OriginalTitleText originalTitleText;
        public PrimaryImage primaryImage;
        public RatingsSummary ratingsSummary;
        public ReleaseYear releaseYear;
        public Object titleEpisode;
        public TitleText titleText;
        public TitleType titleType;
    }

    public class TitleText{
        public String text;
    }

    public class TitleType{
        public String id;
        public String text;
        public DisplayableProperty displayableProperty;
        public ArrayList<Category> categories;
        public boolean canHaveEpisodes;
        public boolean isSeries;
        public boolean isEpisode;
    }

    public class TopRanking{
        public int rank;
    }

    public class Value{
        public String plainText;
    }
}
