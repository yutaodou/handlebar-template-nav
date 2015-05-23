package com.thoughtworks.tools.idea.plugin;

import com.google.common.io.Resources;
import com.intellij.util.containers.MultiMap;
import org.junit.Test;

import java.io.File;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsCollectionContaining.hasItems;
import static org.junit.Assert.assertThat;

public class UsageParserTest {
    @Test
    public void testParse() throws Exception {
        File file = new File(Resources.getResource("page.hbs.html").getPath());
        UsageParser parser = new UsageParser();
        MultiMap<String, Integer> usage = parser.parse(file);
        assertThat(usage.size(), is(2));
        assertThat(usage.get("base"), hasItems(3));
        assertThat(usage.get("partials/partial-one"), hasItems(2, 4));
    }
}