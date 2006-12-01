package org.drools.brms.client.modeldriven;

import org.drools.brms.client.modeldriven.model.FactPattern;
import org.drools.brms.client.modeldriven.model.IPattern;
import org.drools.brms.client.modeldriven.model.RuleModel;

import junit.framework.TestCase;

public class RuleModelTest extends TestCase {

    public void testBoundFactFinder() {
        RuleModel model = new RuleModel();
        
        assertNull(model.getBoundFact( "x" ));
        model.lhs = new IPattern[3];
        
        FactPattern x = new FactPattern("Car");
        model.lhs[0] = x;
        x.boundName = "x";
        
        assertNotNull(model.getBoundFact( "x" ));
        assertEquals(x, model.getBoundFact( "x" ));
        
        FactPattern y = new FactPattern("Car");
        model.lhs[1] = y;
        y.boundName = "y";
        
        FactPattern other = new FactPattern("House");
        model.lhs[2] = other;
        
        assertEquals(y, model.getBoundFact( "y" ));
        assertEquals(x, model.getBoundFact( "x" ));
        
        
        
    }
    
}
