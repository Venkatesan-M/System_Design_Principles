# Snake and Ladder Game - Low Level Design

## Overview
A console-based Snake and Ladder game implementation in Java with multiple players.

## Components

### 1. **Player**
- Simple class with `id` and `name`
- Represents each game participant

### 2. **Dice** 
- Configurable number of dice
- `roll()` method generates random values between 1 and (6 × numberOfDice)

### 3. **Jumper**
- Generic class for both snakes and ladders
- Contains `start` and `end` positions
- Snakes: end < start (move backward)
- Ladders: end > start (move forward)

### 4. **GameBoard**
- Main game logic controller
- Manages player queue, positions, and game flow
- Handles dice rolling, position updates, and win conditions

## Game Flow
1. Players take turns rolling dice
2. Move forward by dice value from current position
3. Check for snakes/ladders at new position
4. If position > board size, stay at current position
5. First player to reach exact board size (100) wins
6. Game continues until only one player remains

## Key Features
- Multiple players support using Queue
- Configurable board size and dice
- Snake and ladder collision detection
- Win condition handling
- Position tracking with HashMap

## Usage
```java
// Initialize components
Dice dice = new Dice(6);
Queue<Player> players = new LinkedList<>();
List<Jumper> snakes = new ArrayList<>();
List<Jumper> ladders = new ArrayList<>();

// Start game
GameBoard game = new GameBoard(dice, players, snakes, ladders, 100);
game.startGame();
```

## Design Pattern
- **Strategy Pattern**: Jumper class handles both snakes and ladders
- **Queue**: Ensures fair turn-based gameplay
- **Separation of Concerns**: Each class has single responsibility