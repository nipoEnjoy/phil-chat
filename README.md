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

The application provides REST API endpoints for managing philharmonic data. The API uses **inheritance-based design** for Events and Venues, where specific types (Competitions, Concerts, Theatres, etc.) inherit from base entities.

**Authentication:** All endpoints require authentication. Some endpoints require specific roles (`ADMIN`, `SUPERADMIN`).

---

### Artists

- **GET** `/api/artists` - Get all artists.
    - Optional query parameters:
        - `genre` (filter by genre name)
        - `impresarioId` (filter by impresario)
        - `multipleGenres` (true to get artists with more than one genre)
- **GET** `/api/artists/{id}` - Get artist by ID.
- **POST** `/api/artists` - Create a new artist. **Requires role: ADMIN or SUPERADMIN**
    - Body: `ArtistCreateRequest` JSON
- **PUT** `/api/artists/{id}` - Update an artist. **Requires role: ADMIN or SUPERADMIN**
    - Body: `ArtistUpdateRequest` JSON
- **DELETE** `/api/artists/{id}` - Delete an artist. **Requires role: SUPERADMIN**

**ArtistCreateRequest / ArtistUpdateRequest:**
```json
{
  "firstName": "John",
  "lastName": "Doe",
  "stageName": "JD",
  "contactInfo": "john@example.com"
}
```

---

### Venues (Base)

All venue types (Theatre, Cinema, ConcertVenue, etc.) inherit from the base `Venue` entity.

- **GET** `/api/venues` - Get all venues.
    - Optional query parameter: `type` (VenueType enum value: THEATRE, CINEMA, CONCERT_VENUE, etc.)
- **GET** `/api/venues/{id}` - Get venue by ID.
- **POST** `/api/venues` - Create a new venue. **Requires role: ADMIN or SUPERADMIN**
    - Body: `VenueCreateRequest` JSON
- **PUT** `/api/venues/{id}` - Update a venue. **Requires role: ADMIN or SUPERADMIN**
    - Body: `VenueUpdateRequest` JSON
- **DELETE** `/api/venues/{id}` - Delete a venue. **Requires role: SUPERADMIN**

**VenueCreateRequest / VenueUpdateRequest:**
```json
{
  "name": "Grand Theatre",
  "venueType": "THEATRE",
  "address": "123 Main St",
  "city": "Moscow",
  "description": "Historic theatre"
}
```

---

### Venues - Theatres

- **GET** `/api/venues/theatres` - Get all theatres.
- **GET** `/api/venues/theatres/{id}` - Get theatre by ID.
- **POST** `/api/venues/theatres` - Create a new theatre. **Requires role: ADMIN or SUPERADMIN**
    - Body: `TheatreCreateRequest` JSON (inherits from VenueCreateRequest)
- **PUT** `/api/venues/theatres/{id}` - Update a theatre. **Requires role: ADMIN or SUPERADMIN**
    - Body: `TheatreUpdateRequest` JSON
- **DELETE** `/api/venues/theatres/{id}` - Delete a theatre. **Requires role: SUPERADMIN**

**TheatreCreateRequest / TheatreUpdateRequest:**
```json
{
  "name": "Grand Theatre",
  "venueType": "THEATRE",
  "address": "123 Main St",
  "city": "Moscow",
  "description": "Historic theatre",
  "capacity": 500,
  "stageWidthMm": 15000,
  "stageDepthMm": 10000
}
```

---

### Venues - Cinemas

- **GET** `/api/venues/cinemas` - Get all cinemas.
- **GET** `/api/venues/cinemas/{id}` - Get cinema by ID.
- **POST** `/api/venues/cinemas` - Create a new cinema. **Requires role: ADMIN or SUPERADMIN**
- **PUT** `/api/venues/cinemas/{id}` - Update a cinema. **Requires role: ADMIN or SUPERADMIN**
- **DELETE** `/api/venues/cinemas/{id}` - Delete a cinema. **Requires role: SUPERADMIN**

**CinemaCreateRequest / CinemaUpdateRequest:**
```json
{
  "name": "Cinema Star",
  "venueType": "CINEMA",
  "address": "456 Oak Ave",
  "city": "Moscow",
  "screenWidthMm": 12000,
  "screenHeightMm": 6000,
  "screenDiagonalMm": 13500,
  "screenAspectRatio": "16:9"
}
```

---

### Events (Base)

All event types (Competition, Concert, Solo, Festival, etc.) inherit from the base `Event` entity.

- **GET** `/api/events` - Get all events.
    - Optional query parameters:
        - `start` and `end` (LocalDateTime for period filtering)
        - `organizerId` (filter by organizer)
        - `venueId` (filter by venue)
- **GET** `/api/events/{id}` - Get event by ID.
- **POST** `/api/events` - Create a new event. **Requires role: ADMIN or SUPERADMIN**
    - Body: `EventCreateRequest` JSON
- **PUT** `/api/events/{id}` - Update an event. **Requires role: ADMIN or SUPERADMIN**
    - Body: `EventUpdateRequest` JSON
- **DELETE** `/api/events/{id}` - Delete an event. **Requires role: SUPERADMIN**

**EventCreateRequest / EventUpdateRequest:**
```json
{
  "title": "Summer Concert",
  "venueId": 5,
  "organizerId": 3,
  "startDatetime": "2026-07-15T18:00:00",
  "endDatetime": "2026-07-15T21:00:00",
  "description": "Outdoor summer concert"
}
```

---

### Events - Competitions

- **GET** `/api/events/competitions` - Get all competitions.
- **GET** `/api/events/competitions/{id}` - Get competition by ID.
- **POST** `/api/events/competitions` - Create a new competition. **Requires role: ADMIN or SUPERADMIN**
    - Body: `CompetitionCreateRequest` JSON (inherits from EventCreateRequest)
- **PUT** `/api/events/competitions/{id}` - Update a competition. **Requires role: ADMIN or SUPERADMIN**
    - Body: `CompetitionUpdateRequest` JSON
- **DELETE** `/api/events/competitions/{id}` - Delete a competition. **Requires role: SUPERADMIN**

**CompetitionCreateRequest / CompetitionUpdateRequest:**
```json
{
  "title": "Piano Competition 2026",
  "venueId": 5,
  "organizerId": 3,
  "startDatetime": "2026-08-01T10:00:00",
  "endDatetime": "2026-08-03T20:00:00",
  "description": "International piano competition",
  "competitionType": "PIANO",
  "rules": "Participants must be under 30 years old",
  "juryInfo": "5 international judges"
}
```

---

### Events - Concerts

- **GET** `/api/events/concerts` - Get all concerts.
- **GET** `/api/events/concerts/{id}` - Get concert by ID.
- **POST** `/api/events/concerts` - Create a new concert. **Requires role: ADMIN or SUPERADMIN**
- **PUT** `/api/events/concerts/{id}` - Update a concert. **Requires role: ADMIN or SUPERADMIN**
- **DELETE** `/api/events/concerts/{id}` - Delete a concert. **Requires role: SUPERADMIN**

**ConcertCreateRequest / ConcertUpdateRequest:**
```json
{
  "title": "Symphony Night",
  "venueId": 5,
  "organizerId": 3,
  "startDatetime": "2026-09-10T19:00:00",
  "endDatetime": "2026-09-10T22:00:00",
  "description": "Classical symphony concert"
}
```

---

### Events - Solo Performances

- **GET** `/api/events/solo` - Get all solo performances.
- **GET** `/api/events/solo/{id}` - Get solo performance by ID.
- **POST** `/api/events/solo` - Create a new solo performance. **Requires role: ADMIN or SUPERADMIN**
- **PUT** `/api/events/solo/{id}` - Update a solo performance. **Requires role: ADMIN or SUPERADMIN**
- **DELETE** `/api/events/solo/{id}` - Delete a solo performance. **Requires role: SUPERADMIN**

**SoloCreateRequest / SoloUpdateRequest:**
```json
{
  "title": "Violin Recital",
  "venueId": 5,
  "organizerId": 3,
  "startDatetime": "2026-10-05T18:00:00",
  "endDatetime": "2026-10-05T20:00:00",
  "description": "Solo violin performance"
}
```

---

### Competition Results

- **GET** `/api/competition-results` - Get all competition results.
    - Optional query parameter: `competitionId` (filter by competition)
- **GET** `/api/competition-results/{id}` - Get competition result by ID.
- **POST** `/api/competition-results` - Create a new competition result. **Requires role: ADMIN or SUPERADMIN**
    - Body: `CompetitionResultCreateRequest` JSON
- **PUT** `/api/competition-results/{id}` - Update a competition result. **Requires role: ADMIN or SUPERADMIN**
    - Body: `CompetitionResultUpdateRequest` JSON
- **DELETE** `/api/competition-results/{id}` - Delete a competition result. **Requires role: SUPERADMIN**

**CompetitionResultCreateRequest / CompetitionResultUpdateRequest:**
```json
{
  "competitionId": 10,
  "artistId": 5,
  "place": 1,
  "award": "Gold Medal"
}
```

---

### Impresarios

- **GET** `/api/impresarios` - Get all impresarios.
    - Optional query parameters:
        - `artistId` (filter by artist)
        - `genre` (filter by genre)
- **GET** `/api/impresarios/{id}` - Get impresario by ID.
- **POST** `/api/impresarios` - Create a new impresario. **Requires role: ADMIN or SUPERADMIN**
    - Body: `ImpresarioCreateRequest` JSON
- **PUT** `/api/impresarios/{id}` - Update an impresario. **Requires role: ADMIN or SUPERADMIN**
    - Body: `ImpresarioUpdateRequest` JSON
- **DELETE** `/api/impresarios/{id}` - Delete an impresario. **Requires role: SUPERADMIN**

**ImpresarioCreateRequest / ImpresarioUpdateRequest:**
```json
{
  "firstName": "Jane",
  "lastName": "Smith",
  "organization": "Artist Management Inc",
  "contactInfo": "jane@management.com"
}
```

---

### Organizers

- **GET** `/api/organizers` - Get all organizers.
- **GET** `/api/organizers/{id}` - Get organizer by ID.
- **POST** `/api/organizers` - Create a new organizer. **Requires role: ADMIN or SUPERADMIN**
    - Body: `OrganizerCreateRequest` JSON
- **PUT** `/api/organizers/{id}` - Update an organizer. **Requires role: ADMIN or SUPERADMIN**
    - Body: `OrganizerUpdateRequest` JSON
- **DELETE** `/api/organizers/{id}` - Delete an organizer. **Requires role: SUPERADMIN**

**OrganizerCreateRequest / OrganizerUpdateRequest:**
```json
{
  "name": "Moscow Philharmonic",
  "contactInfo": "info@philharmonic.ru",
  "type": "STATE"
}
```

---

### Genres

- **GET** `/api/genres` - Get all genres.
- **GET** `/api/genres/{id}` - Get genre by ID.
- **POST** `/api/genres` - Create a new genre. **Requires role: ADMIN or SUPERADMIN**
    - Body: `GenreCreateRequest` JSON
- **PUT** `/api/genres/{id}` - Update a genre. **Requires role: ADMIN or SUPERADMIN**
    - Body: `GenreUpdateRequest` JSON
- **DELETE** `/api/genres/{id}` - Delete a genre. **Requires role: SUPERADMIN**

**GenreCreateRequest / GenreUpdateRequest:**
```json
{
  "name": "Classical",
  "description": "Classical music genre"
}
```

---

## Error Responses

All endpoints return standardized error responses:

**400 Bad Request (Validation Error):**
```json
{
  "timestamp": "2026-06-05T15:30:00",
  "status": 400,
  "error": "Validation Failed",
  "message": "One or more fields have invalid data",
  "path": "/api/artists",
  "details": [
    {
      "field": "firstName",
      "message": "First name cannot be blank"
    }
  ]
}
```

**403 Forbidden:**
```json
{
  "timestamp": "2026-06-05T15:32:00",
  "status": 403,
  "error": "Forbidden",
  "message": "You do not have permission to access this resource",
  "path": "/api/artists/5",
  "details": null
}
```

**404 Not Found:**
```json
{
  "timestamp": "2026-06-05T15:35:00",
  "status": 404,
  "error": "Not Found",
  "message": "Artist with id 999 not found",
  "path": "/api/artists/999",
  "details": null
}
```

**500 Internal Server Error:**
```json
{
  "timestamp": "2026-06-05T15:40:00",
  "status": 500,
  "error": "Internal Server Error",
  "message": "An unexpected error occurred. Please try again later.",
  "path": "/api/events",
  "details": null
}
```