package com.example.movieapplication.models;

import java.util.ArrayList;

public class TopMoviesResponse {

    public boolean status;
    public String message;
    public long timestamp;
    public ArrayList<Datum> data;
    public class CanRateTitle{
        public boolean isRatable;
    }

    public class CategorizedWatchOptionsList{
        public ArrayList<WatchOption> watchOptions;
    }

    public class Category{
        public String id;
        public String text;
        public String value;
    }

    public class CertificateCountry{
        public String id;
        public String text;
    }

    public class ChartMeterRanking{
        public int currentRank;
        public RankChange rankChange;
    }

    public class CorrectionLink{
        public String url;
    }

    public class Country{
        public String id;
        public String text;
    }

    public class Datum{
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
        public Object series;
        public WatchOptionsByCategory watchOptionsByCategory;
        public Plot plot;
        public ReleaseDate releaseDate;
        public TitleCertificate titleCertificate;
        public TitleRuntime titleRuntime;
        public ChartMeterRanking chartMeterRanking;
    }

    public class Description{
        public String value;
    }

    public class DisplayableProperty{
        public Value value;
        public Object qualifiersInMarkdownList;
    }

    public class Icon{
        public String url;
        public int width;
        public int height;
    }

    public class Logos{
        public Icon icon;
        public Slate slate;
    }

    public class Name{
        public String value;
    }

    public class OriginalTitleText{
        public String text;
    }

    public class Plot{
        public String id;
        public Object author;
        public PlotText plotText;
        public CorrectionLink correctionLink;
        public ReportingLink reportingLink;
    }

    public class PlotText{
        public String plainText;
    }

    public class PrimaryImage{
        public String id;
        public String imageUrl;
        public int imageWidth;
        public int imageHeight;
    }

    public class Provider{
        public String id;
        public String categoryType;
        public Description description;
        public Name name;
        public String refTagFragment;
        public Logos logos;
    }

    public class RankChange{
        public String changeDirection;
        public int difference;
    }

    public class RatingsSummary{
        public double aggregateRating;
        public TopRanking topRanking;
        public int voteCount;
    }

    public class ReleaseAttribute{
        public String text;
    }

    public class ReleaseDate{
        public int day;
        public int month;
        public int year;
        public Country country;
        public Object restriction;
        public ArrayList<ReleaseAttribute> releaseAttributes;
    }

    public class ReleaseYear{
        public int year;
        public int endYear;
    }

    public class ReportingLink{
        public String url;
    }

    public class ShortDescription{
        public String value;
    }

    public class Slate{
        public String url;
        public int width;
        public int height;
    }

    public class Title{
        public String value;
    }

    public class TitleCertificate{
        public String rating;
        public CertificateCountry certificateCountry;
        public String ratingReason;
    }

    public class TitleRuntime{
        public int seconds;
        public DisplayableProperty displayableProperty;
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

    public class WatchOption{
        public Provider provider;
        public Title title;
        public Description description;
        public ShortDescription shortDescription;
        public String link;
    }

    public class WatchOptionsByCategory{
        public ArrayList<CategorizedWatchOptionsList> categorizedWatchOptionsList;
    }



}
