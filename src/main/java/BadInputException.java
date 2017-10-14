class BadInputException extends RuntimeException {
    BadInputException() {
        System.out.println("Please provide a comma separated list");
    }
}
