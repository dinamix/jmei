package ca.mcgill.music.ddmal.mei;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class MeiDocumentTest {

    private MeiElement e;
    private MeiElement f;
    private MeiElement g;
    private MeiElement h;
    private MeiElement i;
    private MeiElement j;
    private MeiElement k;
    private MeiElement l;

    @Before
    public void setup() {
        e = new MeiElement("e", "id-e");
        f = new MeiElement("f", "id-f");
        g = new MeiElement("g", "id-g");
        h = new MeiElement("same", "id-h");
        i = new MeiElement("i", "id-i");
        j = new MeiElement("same", "id-j");
        k = new MeiElement("same", "id-k");
        l = new MeiElement("l", "id-l");

        e.addChild(f);
        e.addChild(g);
        g.addChild(h);
        g.addChild(i);
        h.addChild(j);
        j.addChild(k);
        j.addChild(l);
    }

    @Test
    public void getElementById() {
        MeiDocument d = new MeiDocument();
        assertThat(d.getElementById("id-g"), is(nullValue()));
        d.setRootElement(e);
        assertThat(d.getElementById("id-e"), is(e));
        assertThat(d.getElementById("id-f"), is(f));
        assertThat(d.getElementById("id-g"), is(g));
        assertThat(d.getElementById("id-h"), is(h));
        assertThat(d.getElementById("id-i"), is(i));
        assertThat(d.getElementById("id-j"), is(j));
        assertThat(d.getElementById("id-k"), is(k));
        assertThat(d.getElementById("id-l"), is(l));
    }

    @Test
    public void getElementsByName() {
        MeiDocument d = new MeiDocument();
        assertThat(d.getElementsByName("same").size(), is(0));
        d.setRootElement(e);
        assertThat(d.getElementsByName("same").size(), is(3));
    }
}
