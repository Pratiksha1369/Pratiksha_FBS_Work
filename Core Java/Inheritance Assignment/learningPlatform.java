class LearningPlatform {
    String platformName;
    String instructor;
    int enrolledStudents;
    double rating;
    static int count = 0;

    LearningPlatform() {
        System.out.println("LearningPlatform default constructor");
        platformName = "Unknown";
        instructor = "Anonymous";
        enrolledStudents = 0;
        rating = 0.0;
        count++;
    }

    LearningPlatform(String platformName, String instructor, int enrolledStudents, double rating) {
        System.out.println("LearningPlatform parameterized constructor");
        this.platformName = platformName;
        this.instructor = instructor;
        this.enrolledStudents = enrolledStudents;
        this.rating = rating;
        count++;
    }

    void display() {
        System.out.println("Platform: " + platformName);
        System.out.println("Instructor: " + instructor);
        System.out.println("Enrolled Students: " + enrolledStudents);
        System.out.println("Rating: " + rating);
    }

    static int getCount() {
        return count;
    }
}

// YouTubeLearning subclass
class YouTubeLearning extends LearningPlatform {
    int videosCount;
    boolean monetized;

    YouTubeLearning() {
        super();
        videosCount = 0;
        monetized = false;
        System.out.println("YouTubeLearning default constructor");
    }

    YouTubeLearning(String instructor, int enrolledStudents, double rating, int videosCount, boolean monetized) {
        super("YouTube", instructor, enrolledStudents, rating);
        this.videosCount = videosCount;
        this.monetized = monetized;
        System.out.println("YouTubeLearning parameterized constructor");
    }

    void display() {
        super.display();
        System.out.println("Videos Count: " + videosCount);
        System.out.println("Monetized: " + monetized);
    }
}

// UdemyCourse subclass
class UdemyCourse extends LearningPlatform {
    int durationHours;
    boolean certificateAvailable;

    UdemyCourse() {
        super();
        durationHours = 0;
        certificateAvailable = false;
        System.out.println("UdemyCourse default constructor");
    }

    UdemyCourse(String instructor, int enrolledStudents, double rating, int durationHours, boolean certificateAvailable) {
        super("Udemy", instructor, enrolledStudents, rating);
        this.durationHours = durationHours;
        this.certificateAvailable = certificateAvailable;
        System.out.println("UdemyCourse parameterized constructor");
    }

    void display() {
        super.display();
        System.out.println("Duration: " + durationHours + " hours");
        System.out.println("Certificate: " + certificateAvailable);
    }
}

// SkillShareClass subclass
class SkillShareClass extends LearningPlatform {
    int lessonsCount;
    String skillCategory;

    SkillShareClass() {
        super();
        lessonsCount = 0;
        skillCategory = "Unknown";
        System.out.println("SkillShareClass default constructor");
    }

    SkillShareClass(String instructor, int enrolledStudents, double rating, int lessonsCount, String skillCategory) {
        super("SkillShare", instructor, enrolledStudents, rating);
        this.lessonsCount = lessonsCount;
        this.skillCategory = skillCategory;
        System.out.println("SkillShareClass parameterized constructor");
    }

    void display() {
        super.display();
        System.out.println("Lessons: " + lessonsCount);
        System.out.println("Skill Category: " + skillCategory);
    }
}

class LearningPlatformInheritance {
    public static void main(String[] args) {
        YouTubeLearning yt = new YouTubeLearning("John Doe", 5000, 4.6, 120, true);
        yt.display();

        System.out.println("\n");

        UdemyCourse ud = new UdemyCourse("Jane Smith", 2000, 4.8, 12, true);
        ud.display();

        System.out.println("\n");

        SkillShareClass sc = new SkillShareClass("Alex Green", 800, 4.5, 10, "Graphic Design");
        sc.display();

        System.out.println("\nTotal Learning Platforms Created: " + LearningPlatform.getCount());
    }
}
