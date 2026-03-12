import java.time.LocalDate;
import java.time.LocalDateTime;

public class TaskDateInfo {

    LocalDate dueDate;
    LocalDateTime createdAt;

    public TaskDateInfo(LocalDateTime creationTime, LocalDate dueDate) {
        this.createdAt = creationTime;
        this.dueDate = dueDate;
    }

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public LocalDateTime getCreatedAt() {
        return this.createdAt;
    }

    public boolean isOverdue() {
        return getDueDate().isBefore(LocalDate.now());
    }

}
