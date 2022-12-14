//package agh.ics.oop;
//
//import org.junit.jupiter.api.Test;
//import java.util.List;
//import java.util.Optional;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//
//public class SimulationEngineTest {
//
//    @Test
//    void testRunWithAnimal() {
//        // given
//        IWorldMap map = new RectangularMap(5,5);
//        var listOfDirections = List.of(
//                MoveDirection.FORWARD,
//                MoveDirection.RIGHT,
//                MoveDirection.LEFT,
//                MoveDirection.FORWARD,
//                MoveDirection.BACKWARD,
//                MoveDirection.FORWARD);
//        List<Vector2d> emptyListOfVectors = List.of();
//        var animal = new Animal(map, new Vector2d(2, 1));
//        var engine = new SimulationEngine(listOfDirections, map, emptyListOfVectors);
//        var expectedPosition = new Vector2d(2, 1);
//        var expectedDirection = MapDirection.NORTH;
//        var expectedEmptyObject = Optional.empty();
//        // when
//        engine.run();
//        var actualStartPosition = map.objectAt(new Vector2d(2, 2));
//        var actualPosition = animal.getPosition();
//        var actualDirection = animal.getDirection();
//        // then
//        assertEquals(expectedEmptyObject, actualStartPosition);
//        assertEquals(expectedPosition, actualPosition);
//        assertEquals(expectedDirection, actualDirection);
//    }
//
//    @Test
//    void testRunWithAnimals() {
//        // given
//        var map = new GrassField(10);
//        var listOfDirections = List.of(
//                MoveDirection.FORWARD,
//                MoveDirection.BACKWARD,
//                MoveDirection.RIGHT,
//                MoveDirection.LEFT,
//                MoveDirection.FORWARD,
//                MoveDirection.FORWARD,
//                MoveDirection.RIGHT,
//                MoveDirection.RIGHT,
//                MoveDirection.FORWARD,
//                MoveDirection.FORWARD,
//                MoveDirection.FORWARD,
//                MoveDirection.FORWARD,
//                MoveDirection.FORWARD);
//        List<Vector2d> positions = List.of(new Vector2d(2,2), new Vector2d(3,4));
//        var animal1ExpectedPosition = new Vector2d(3, 0);
//        var animal2ExpectedPosition = new Vector2d(2, 4);
//        var animal1ExpectedDirection = MapDirection.SOUTH;
//        var animal2ExpectedDirection = MapDirection.NORTH;
//        // when
//        var engine = new SimulationEngine(listOfDirections, map, positions);
//        engine.run();
//        var animals = engine.getAnimals();
//        var animal1 = engine.getPositionOfAnimal(0);
//        var animal2 = engine.getPositionOfAnimal(1);
//        // test
//        assertEquals(animal1ExpectedPosition, animal1);
//        assertEquals(animal2ExpectedPosition, animal2);
//        assertEquals(animal1ExpectedDirection, animal1);
//        assertEquals(animal2ExpectedDirection, animal2);
//    }
//}
