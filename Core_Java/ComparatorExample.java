import java.util.*;

class Job implements Comparable<Job>{

    private String title;
    private Integer priority;
    private Integer salary;

    public Job(String title, Integer priority, Integer salary) {
        this.title = title;
        this.priority = priority;
        this.salary = salary;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    @Override
    public int compareTo(Job other) {
        int a = this.priority.compareTo(other.priority);
        if(a == 0){
            return this.title.compareTo(other.title);
        }
        return a;
    }

    @Override
    public String toString() {
        return (title + " | Priority: " + priority + " | salary : " + salary);
    }
}
class PriorityComparator implements Comparator<Job> {
    @Override
    public int compare(Job j1, Job j2) {
        return j1.getTitle().compareTo(j2.getTitle());
    }
}
public class ComparatorExample {
    public static void main(String[] args) {
        LinkedList<Job> jobs = new LinkedList<>();

        jobs.add(new Job("Developer", 2, 60000));
        jobs.add(new Job("AI Eng", 1, 80000));
        jobs.add(new Job("tester", 3, 40000));

        System.out.println("Before Sorting: ");
        for(Job job : jobs) {
            System.out.println(job);
        }

        Collections.sort(jobs, new PriorityComparator());

        System.out.println("After sorting (by priority):");
        for(Job job : jobs) {
            System.out.println(job);
        }
    }
}
