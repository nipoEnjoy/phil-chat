# Philharmonic Project

This is a Spring Boot application for managing a philharmonic database using JPA entities and PostgreSQL.

## Prerequisites

- Java 25
- Maven
- PostgreSQL 18

## Dependencies

Add the following dependency to your `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency>
```

## Running the Application

1. Update the database configuration in `src/main/resources/application.properties` with your PostgreSQL credentials.
2. Run the application using Maven:

```bash
mvn spring-boot:run
```

When you run the application, Hibernate will automatically create/update the database tables based on the JPA entities (ddl-auto=update).

## API Contracts

The application provides REST API endpoints for managing philharmonic data. Below is the documentation for the available endpoints.

### Artists

- **GET** `/api/artists` - Get all artists. Optional query parameters: `genre` (filter by genre name), `impresarioId` (filter by impresario), `multipleGenres` (true to get artists with more than one genre).
- **GET** `/api/artists/{id}` - Get artist by ID.
- **POST** `/api/artists` - Create a new artist. Body: Artist JSON.
- **PUT** `/api/artists/{id}` - Update an artist. Body: Artist JSON.
- **DELETE** `/api/artists/{id}` - Delete an artist.

### Venues

- **GET** `/api/venues` - Get all venues. Optional query parameter: `type` (VenueType enum value).
- **GET** `/api/venues/{id}` - Get venue by ID.
- **POST** `/api/venues` - Create a new venue. Body: Venue JSON.
- **PUT** `/api/venues/{id}` - Update a venue. Body: Venue JSON.
- **DELETE** `/api/venues/{id}` - Delete a venue.

### Events

- **GET** `/api/events` - Get all events. Optional query parameters: `start` and `end` (LocalDateTime for period), `organizerId`, `venueId`.
- **GET** `/api/events/{id}` - Get event by ID.
- **POST** `/api/events` - Create a new event. Body: Event JSON.
- **PUT** `/api/events/{id}` - Update an event. Body: Event JSON.
- **DELETE** `/api/events/{id}` - Delete an event.

### Impresarios

- **GET** `/api/impresarios` - Get all impresarios. Optional query parameters: `artistId`, `genre`.
- **GET** `/api/impresarios/{id}` - Get impresario by ID.
- **POST** `/api/impresarios` - Create a new impresario. Body: Impresario JSON.
- **PUT** `/api/impresarios/{id}` - Update an impresario. Body: Impresario JSON.
- **DELETE** `/api/impresarios/{id}` - Delete an impresario.

### Competitions

- **GET** `/api/competitions` - Get all competitions.
- **GET** `/api/competitions/{id}` - Get competition by ID.
- **POST** `/api/competitions` - Create a new competition. Body: Competition JSON.
- **PUT** `/api/competitions/{id}` - Update a competition. Body: Competition JSON.
- **DELETE** `/api/competitions/{id}` - Delete a competition.

### Competition Results

- **GET** `/api/competition-results` - Get all competition results. Optional query parameter: `competitionId`.
- **GET** `/api/competition-results/{id}` - Get competition result by ID.
- **POST** `/api/competition-results` - Create a new competition result. Body: CompetitionResult JSON.
- **PUT** `/api/competition-results/{id}` - Update a competition result. Body: CompetitionResult JSON.
- **DELETE** `/api/competition-results/{id}` - Delete a competition result.

### Organizers

- **GET** `/api/organizers` - Get all organizers.
- **GET** `/api/organizers/{id}` - Get organizer by ID.
- **POST** `/api/organizers` - Create a new organizer. Body: Organizer JSON.
- **PUT** `/api/organizers/{id}` - Update an organizer. Body: Organizer JSON.
- **DELETE** `/api/organizers/{id}` - Delete an organizer.