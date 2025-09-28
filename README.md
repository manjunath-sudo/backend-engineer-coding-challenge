# Backend Engineer Coding Challenge

### Build & Run
```bash
./run.sh
```

### API Usage
POST http://localhost:8080/occupancy

Request:
```json
{
  "premiumRooms": 7,
  "economyRooms": 5,
  "potentialGuests": [23, 45, 155, 374, 22, 99.99, 100, 101, 115, 209]
}
```

Response:
```json
{
  "usagePremium": 6,
  "revenuePremium": 1054.0,
  "usageEconomy": 4,
  "revenueEconomy": 189.99
}
```

### Tests
Run tests with:
```bash
mvn test
```
