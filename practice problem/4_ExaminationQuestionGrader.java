import java.util.*;

public class ExaminationQuestionGrader {
    static abstract class Question {
        protected String correctAnswer, studentAnswer;
        protected double points;

        Question(String correctAnswer, String studentAnswer, double points) {
            this.correctAnswer = correctAnswer;
            this.studentAnswer = studentAnswer;
            this.points = points;
        }

        abstract double score();
    }

    static class MCQ extends Question {
        MCQ(String c, String s, double p) { super(c, s, p); }
        double score() { return studentAnswer.equals(correctAnswer) ? points : 0; }
    }

    static class TrueFalse extends Question {
        TrueFalse(String c, String s, double p) { super(c, s, p); }
        double score() { return studentAnswer.equals(correctAnswer) ? points : 0; }
    }

    static class Essay extends Question {
        Essay(String c, String s, double p) { super(c, s, p); }

        double score() {
            String answer = studentAnswer.toLowerCase();
            String[] keywords = correctAnswer.split(",");
            int found = 0;

            for (String keyword : keywords) {
                if (answer.contains(keyword.trim().toLowerCase()))
                    found++;
            }

            if (found >= 2) return points * 0.75;
            if (found == 1) return points * 0.50;
            return 0;
        }
    }

    static List<String> parseQuotedFields(String line) {
        List<String> fields = new ArrayList<>();
        java.util.regex.Matcher m =
            java.util.regex.Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);

        while (m.find())
            fields.add(m.group(1) != null ? m.group(1) : m.group(2));

        return fields;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        List<Question> questions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            List<String> f = parseQuotedFields(sc.nextLine());

            String type = f.get(0);
            String correct = f.get(2);
            String student = f.get(3);
            double points = Double.parseDouble(f.get(4));

            if (type.equals("MCQ"))
                questions.add(new MCQ(correct, student, points));
            else if (type.equals("TF"))
                questions.add(new TrueFalse(correct, student, points));
            else
                questions.add(new Essay(correct, student, points));
        }

        double total = 0;
        for (Question q : questions) {
            double score = q.score();
            total += score;
            System.out.printf("%s: %.2f%n", q.getClass().getSimpleName().equals("TrueFalse") ? "TF" :
                    q.getClass().getSimpleName().toUpperCase(), score);
        }
        System.out.printf("Total Score: %.2f%n", total);
    }
}