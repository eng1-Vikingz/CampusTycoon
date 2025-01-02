package CampusTycoon.Buildings;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import CampusTycoon.Game.Buildings.Accommodation;
import CampusTycoon.Game.Buildings.Building;
import CampusTycoon.Game.Buildings.Cafeteria;
import CampusTycoon.Game.Buildings.Relaxation;
import CampusTycoon.Game.Buildings.SpaceStation;
import CampusTycoon.Game.Buildings.Study;
import CampusTycoon.Util.Types.Coordinate;

class BuildingsTest {

    Building acom, cafe, relax, space, study;

    @BeforeEach
    public void testCreateBuildings() {

        acom = new Accommodation();
        cafe = new Cafeteria();
        relax = new Relaxation(0);
        space = new SpaceStation(new Coordinate());
        study = new Study(0);

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
        assertEquals(true, false);
    }   


}