package pages.musicPage;

record Track (String name, String author, String duration) {

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || !(obj instanceof Track))
            return false;
        Track oth = (Track) obj;
        return oth.author == author && oth.name == name && oth.duration == duration;
    }
}
