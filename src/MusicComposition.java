import java.util.Objects;

// Узагальнений клас для музичних композицій
 class MusicComposition {
    private String title;
    private String artist;
    private int duration;
    private String style;

    public MusicComposition(String title, String artist, int duration, String style) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.style = style;
    }

    public int getDuration() {
        return duration;
    }

    public String getStyle() {
        return style;
    }

    @Override
    public String toString() {
        return title + " by " + artist + " (" + duration + " sec)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        MusicComposition that = (MusicComposition) obj;
        return duration == that.duration &&
                Objects.equals(title, that.title) &&
                Objects.equals(artist, that.artist) &&
                Objects.equals(style, that.style);
    }

}
