# Curl Examples for Philharmonic API

This file provides curl command examples for all REST API endpoints.

Assume the application is running on `http://localhost:8080`.

## Artists

### Get all artists
```bash
curl -X GET "http://localhost:8080/api/artists"
```

### Get artists by genre
```bash
curl -X GET "http://localhost:8080/api/artists?genre=ROCK"
```

### Get artists by impresario
```bash
curl -X GET "http://localhost:8080/api/artists?impresarioId=1"
```

### Get artists with multiple genres
```bash
curl -X GET "http://localhost:8080/api/artists?multipleGenres=true"
```

### Get artist by ID
```bash
curl -X GET "http://localhost:8080/api/artists/1"
```

### Create a new artist
```bash
curl -X POST "http://localhost:8080/api/artists" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "John",
    "lastName": "Doe",
    "stageName": "Johnny",
    "contactInfo": "john@example.com"
  }'
```

### Update an artist
```bash
curl -X PUT "http://localhost:8080/api/artists/1" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Jane",
    "lastName": "Doe",
    "stageName": "Janey",
    "contactInfo": "jane@example.com"
  }'
```

### Delete an artist
```bash
curl -X DELETE "http://localhost:8080/api/artists/1"
```

## Venues

### Get all venues
```bash
curl -X GET "http://localhost:8080/api/venues"
```

### Get venues by type
```bash
curl -X GET "http://localhost:8080/api/venues?type=THEATRE"
```

### Get venue by ID
```bash
curl -X GET "http://localhost:8080/api/venues/1"
```

### Create a new venue
```bash
curl -X POST "http://localhost:8080/api/venues" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Grand Theater",
    "venueType": "THEATRE",
    "address": "123 Main St",
    "city": "Cityville",
    "description": "A beautiful theater"
  }'
```

### Update a venue
```bash
curl -X PUT "http://localhost:8080/api/venues/1" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Updated Theater",
    "venueType": "THEATRE",
    "address": "456 Elm St",
    "city": "Townsville",
    "description": "An updated theater"
  }'
```

### Delete a venue
```bash
curl -X DELETE "http://localhost:8080/api/venues/1"
```

## Events

### Get all events
```bash
curl -X GET "http://localhost:8080/api/events"
```

### Get events by period
```bash
curl -X GET "http://localhost:8080/api/events?start=2026-01-01T00:00:00&end=2026-12-31T23:59:59"
```

### Get events by organizer
```bash
curl -X GET "http://localhost:8080/api/events?organizerId=1"
```

### Get events by venue
```bash
curl -X GET "http://localhost:8080/api/events?venueId=1"
```

### Get event by ID
```bash
curl -X GET "http://localhost:8080/api/events/1"
```

### Create a new event
```bash
curl -X POST "http://localhost:8080/api/events" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Concert Night",
    "eventType": "CONCERT",
    "venue": {"id": 1},
    "organizer": {"id": 1},
    "startDatetime": "2026-05-10T19:00:00",
    "endDatetime": "2026-05-10T21:00:00",
    "description": "An amazing concert"
  }'
```

### Update an event
```bash
curl -X PUT "http://localhost:8080/api/events/1" \
  -H "Content-Type: application/json" \
  -d '{
    "title": "Updated Concert",
    "eventType": "CONCERT",
    "venue": {"id": 1},
    "organizer": {"id": 1},
    "startDatetime": "2026-05-11T19:00:00",
    "endDatetime": "2026-05-11T21:00:00",
    "description": "Updated concert details"
  }'
```

### Delete an event
```bash
curl -X DELETE "http://localhost:8080/api/events/1"
```

## Impresarios

### Get all impresarios
```bash
curl -X GET "http://localhost:8080/api/impresarios"
```

### Get impresarios by artist
```bash
curl -X GET "http://localhost:8080/api/impresarios?artistId=1"
```

### Get impresarios by genre
```bash
curl -X GET "http://localhost:8080/api/impresarios?genre=ROCK"
```

### Get impresario by ID
```bash
curl -X GET "http://localhost:8080/api/impresarios/1"
```

### Create a new impresario
```bash
curl -X POST "http://localhost:8080/api/impresarios" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Agent",
    "lastName": "Smith",
    "organization": "Talent Co",
    "contactInfo": "agent@talent.com"
  }'
```

### Update an impresario
```bash
curl -X PUT "http://localhost:8080/api/impresarios/1" \
  -H "Content-Type: application/json" \
  -d '{
    "firstName": "Updated Agent",
    "lastName": "Smith",
    "organization": "Updated Talent Co",
    "contactInfo": "updated@talent.com"
  }'
```

### Delete an impresario
```bash
curl -X DELETE "http://localhost:8080/api/impresarios/1"
```

## Competitions

### Get all competitions
```bash
curl -X GET "http://localhost:8080/api/competitions"
```

### Get competition by ID
```bash
curl -X GET "http://localhost:8080/api/competitions/1"
```

### Create a new competition
```bash
curl -X POST "http://localhost:8080/api/competitions" \
  -H "Content-Type: application/json" \
  -d '{
    "event": {"id": 1},
    "competitionType": "Singing",
    "rules": "Standard rules",
    "juryInfo": "Expert jury"
  }'
```

### Update a competition
```bash
curl -X PUT "http://localhost:8080/api/competitions/1" \
  -H "Content-Type: application/json" \
  -d '{
    "event": {"id": 1},
    "competitionType": "Updated Singing",
    "rules": "Updated rules",
    "juryInfo": "Updated jury"
  }'
```

### Delete a competition
```bash
curl -X DELETE "http://localhost:8080/api/competitions/1"
```

## Competition Results

### Get all competition results
```bash
curl -X GET "http://localhost:8080/api/competition-results"
```

### Get competition results by competition
```bash
curl -X GET "http://localhost:8080/api/competition-results?competitionId=1"
```

### Get competition result by ID
```bash
curl -X GET "http://localhost:8080/api/competition-results/1"
```

### Create a new competition result
```bash
curl -X POST "http://localhost:8080/api/competition-results" \
  -H "Content-Type: application/json" \
  -d '{
    "competition": {"id": 1},
    "artist": {"id": 1},
    "place": 1,
    "award": "Gold Medal"
  }'
```

### Update a competition result
```bash
curl -X PUT "http://localhost:8080/api/competition-results/1" \
  -H "Content-Type: application/json" \
  -d '{
    "competition": {"id": 1},
    "artist": {"id": 1},
    "place": 2,
    "award": "Silver Medal"
  }'
```

### Delete a competition result
```bash
curl -X DELETE "http://localhost:8080/api/competition-results/1"
```

## Organizers

### Get all organizers
```bash
curl -X GET "http://localhost:8080/api/organizers"
```

### Get organizer by ID
```bash
curl -X GET "http://localhost:8080/api/organizers/1"
```

### Create a new organizer
```bash
curl -X POST "http://localhost:8080/api/organizers" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Event Masters",
    "contactInfo": "info@eventmasters.com",
    "type": "PRIVATE"
  }'
```

### Update an organizer
```bash
curl -X PUT "http://localhost:8080/api/organizers/1" \
  -H "Content-Type: application/json" \
  -d '{
    "name": "Updated Event Masters",
    "contactInfo": "updated@eventmasters.com",
    "type": "MUNICIPAL"
  }'
```

### Delete an organizer
```bash
curl -X DELETE "http://localhost:8080/api/organizers/1"
```