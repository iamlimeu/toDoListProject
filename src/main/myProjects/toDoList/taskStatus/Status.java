package main.myProjects.toDoList.taskStatus;

public enum Status {
        COMPLETED("Выполнена"),
        IN_WORK("В процессе"),
        UNCOMPLETED("Невыполнена");

        private final String status;

        Status(String status) {
            this.status = status;
        }

        public String getStatus() {
            return status;
        }
    }
