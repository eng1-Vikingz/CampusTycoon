package CampusTycoon.Game.Buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestTemplate;

import CampusTycoon.Game.Buildings.Accommodation;
import CampusTycoon.Game.Buildings.Building;
import CampusTycoon.Game.Buildings.Cafeteria;
import CampusTycoon.Game.Buildings.Relaxation;
import CampusTycoon.Game.Buildings.SpaceStation;
import CampusTycoon.Game.Buildings.Study;
import CampusTycoon.Game.GameLogic.BuildingCounter;
import CampusTycoon.Util.Types.Coordinate;

class BuildingsTest {

    static Building acom, cafe, relax, space, study;

    @BeforeAll
    public static void testCreateBuildings() {

        acom = new Accommodation();
        cafe = new Cafeteria();
        relax = new Relaxation(0);
        space = new SpaceStation(new Coordinate());
        study = new Study(0);

    }

    @Test
    public void testBuildingConstructors(){

        Building build1 = new Building();
        Building build2 = new Building(new Coordinate(1,1));

        assertEquals(new Coordinate(0,0), build1.position);
        assertEquals(new Coordinate(1,1), build2.position);

    }




    @Test
    public void testCreateBuildingsWithPosition() {

        acom = new Accommodation(new Coordinate(10, 15));
        cafe = new Cafeteria(new Coordinate(10, 15));
        relax = new Relaxation(new Coordinate(10, 15), 0);
        space = new SpaceStation(new Coordinate(10, 15));
        study = new Study(new Coordinate(10, 15), 0);


        assertEquals(new Coordinate(10,15), acom.position);
        assertEquals(new Coordinate(10,15), cafe.position);
        assertEquals(new Coordinate(10,15), relax.position);
        assertEquals(new Coordinate(10,15), space.position);
        assertEquals(new Coordinate(10,15), study.position);

    }

    @Test
    public void testSetPosition(){

        Coordinate pos = new Coordinate(10, 15);

        acom.setPosition(pos);
        cafe.setPosition(pos);
        relax.setPosition(pos);
        space.setPosition(pos);
        study.setPosition(pos);

        assertEquals(new Coordinate(10,15), acom.position);
        assertEquals(new Coordinate(10,15), cafe.position);
        assertEquals(new Coordinate(10,15), relax.position);
        assertEquals(new Coordinate(10,15), space.position);
        assertEquals(new Coordinate(10,15), study.position);
    }   


    @Test
    public void testIncrementBuildingCounter(){
        
        acom.incrementBuildingCounter();
        cafe.incrementBuildingCounter();
        relax.incrementBuildingCounter();
        study.incrementBuildingCounter();

        assertEquals(1, BuildingCounter.getBuildingCountByBuilding("Accommodation"));
        assertEquals(1, BuildingCounter.getBuildingCountByBuilding("Cafeteria"));
        assertEquals(1, BuildingCounter.getBuildingCountByBuilding("Relaxation"));
        assertEquals(1, BuildingCounter.getBuildingCountByBuilding("Study"));


        Building b = new Building();
        b.incrementBuildingCounter();

        assertEquals(1, BuildingCounter.getBuildingCountByBuilding("default"));

    }

}