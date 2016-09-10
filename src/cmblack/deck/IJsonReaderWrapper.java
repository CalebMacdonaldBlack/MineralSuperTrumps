package cmblack.deck;

import com.google.gson.stream.JsonReader;

import java.io.FileNotFoundException;
import java.io.StringReader;

/**
 * Created by calebmacdonaldblack on 10/09/2016.
 */
public interface IJsonReaderWrapper {
    JsonReader getReader() throws FileNotFoundException;

    class FakeJsonReaderWrapper implements  IJsonReaderWrapper {

        private final String jsonText = "{\n" +
                "  \"cards\": [\n" +
                "    {\n" +
                "      \"fileName\": \"Slide01.jpg\",\n" +
                "      \"imageName\": \"Slide01\",\n" +
                "      \"title\": \"Quartz\",\n" +
                "      \"chemistry\": \"SiO_2\",\n" +
                "      \"classification\": \"tectosilicate\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"7\",\n" +
                "      \"specific_gravity\": \"2.65\",\n" +
                "      \"cleavage\": \"poor/none\",\n" +
                "      \"crustal_abundance\": \"high\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide02.jpg\",\n" +
                "      \"imageName\": \"Slide02\",\n" +
                "      \"title\": \"Plagioclase\",\n" +
                "      \"chemistry\": \"Na Al Si_3 O_8 - Ca Al_2 Si_2 O_8\",\n" +
                "      \"classification\": \"tectosilicate\",\n" +
                "      \"crystal_system\": \"triclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"6-6.5\",\n" +
                "      \"specific_gravity\": \"2.6-2.8\",\n" +
                "      \"cleavage\": \"1 perfect, 1 good\",\n" +
                "      \"crustal_abundance\": \"very high\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide03.jpg\",\n" +
                "      \"imageName\": \"Slide03\",\n" +
                "      \"title\": \"Orthoclase\",\n" +
                "      \"chemistry\": \"K Al Si_3 O_3\",\n" +
                "      \"classification\": \"tectosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"6-6.5\",\n" +
                "      \"specific_gravity\": \"2.5-2.6\",\n" +
                "      \"cleavage\": \"1 perfect, 1 good\",\n" +
                "      \"crustal_abundance\": \"high\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide04.jpg\",\n" +
                "      \"imageName\": \"Slide04\",\n" +
                "      \"title\": \"Biotite\",\n" +
                "      \"chemistry\": \"K(Fe, Mg)_3 Al Si_3 O_10 (OH)_2 \",\n" +
                "      \"classification\": \"phyllosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"2.5-3\",\n" +
                "      \"specific_gravity\": \"2.7-3.3\",\n" +
                "      \"cleavage\": \"1 perfect\",\n" +
                "      \"crustal_abundance\": \"moderate\",\n" +
                "      \"economic_value\": \"low\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide05.jpg\",\n" +
                "      \"imageName\": \"Slide05\",\n" +
                "      \"title\": \"Muscovite\",\n" +
                "      \"chemistry\": \"K Al_3 Si_3 O_10 (O H)_2\",\n" +
                "      \"classification\": \"phyllosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"2.5-3\",\n" +
                "      \"specific_gravity\": \"2.8-2.9\",\n" +
                "      \"cleavage\": \"1 perfect\",\n" +
                "      \"crustal_abundance\": \"moderate\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide06.jpg\",\n" +
                "      \"imageName\": \"Slide06\",\n" +
                "      \"title\": \"Hornblende\",\n" +
                "      \"chemistry\": \"Ca_2 (Mg, Fe)_4 Al_2 Si_7 O_22 (OH)_2\",\n" +
                "      \"classification\": \"inosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5-6\",\n" +
                "      \"specific_gravity\": \"3.0-3.5\",\n" +
                "      \"cleavage\": \"2 good\",\n" +
                "      \"crustal_abundance\": \"moderate\",\n" +
                "      \"economic_value\": \"trivial\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide07.jpg\",\n" +
                "      \"imageName\": \"Slide07\",\n" +
                "      \"title\": \"Actinolite\",\n" +
                "      \"chemistry\": \"Ca_2 (Mg, Fe)_5 Si_8 O_22 (OH)_2\",\n" +
                "      \"classification\": \"inosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5-6\",\n" +
                "      \"specific_gravity\": \"3.0-3.5\",\n" +
                "      \"cleavage\": \"2 good\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"low\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide08.jpg\",\n" +
                "      \"imageName\": \"Slide08\",\n" +
                "      \"title\": \"Glaucophane\",\n" +
                "      \"chemistry\": \"Na_2 (Mg, Fe)_3 Al_2 Si_8 O_22 (OH)_2 \",\n" +
                "      \"classification\": \"inosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"6\",\n" +
                "      \"specific_gravity\": \"3.0-3.2\",\n" +
                "      \"cleavage\": \"2 good\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"trivial\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide09.jpg\",\n" +
                "      \"imageName\": \"Slide09\",\n" +
                "      \"title\": \"Olivine\",\n" +
                "      \"chemistry\": \"(Mg, Fe)_2 Si O_4\",\n" +
                "      \"classification\": \"nesosilicate\",\n" +
                "      \"crystal_system\": \"orthorhombic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"mantle\"\n" +
                "      ],\n" +
                "      \"hardness\": \"6.5-7\",\n" +
                "      \"specific_gravity\": \"3.2-4.4\",\n" +
                "      \"cleavage\": \"2 poor\",\n" +
                "      \"crustal_abundance\": \"high\",\n" +
                "      \"economic_value\": \"low\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide10.jpg\",\n" +
                "      \"imageName\": \"Slide10\",\n" +
                "      \"title\": \"Garnet\",\n" +
                "      \"chemistry\": \"(Fe, Mg, Ca, Mn)_3 (Al, Fe)_2 Si_3 O_12\",\n" +
                "      \"classification\": \"nesosilicate\",\n" +
                "      \"crystal_system\": \"isometric\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"mantle\"\n" +
                "      ],\n" +
                "      \"hardness\": \"6-7.5\",\n" +
                "      \"specific_gravity\": \"3.5-4.3\",\n" +
                "      \"cleavage\": \"none\",\n" +
                "      \"crustal_abundance\": \"moderate\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide11.jpg\",\n" +
                "      \"imageName\": \"Slide11\",\n" +
                "      \"title\": \"Titanite\",\n" +
                "      \"chemistry\": \"Ca Ti Si O_5\",\n" +
                "      \"classification\": \"nesosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5-5.5\",\n" +
                "      \"specific_gravity\": \"3.4-3.6\",\n" +
                "      \"cleavage\": \"3 good\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"low\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide12.jpg\",\n" +
                "      \"imageName\": \"Slide12\",\n" +
                "      \"title\": \"Zircon\",\n" +
                "      \"chemistry\": \"Zr Si O_4\",\n" +
                "      \"classification\": \"nesosilicate\",\n" +
                "      \"crystal_system\": \"tetragonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"7.5\",\n" +
                "      \"specific_gravity\": \"4.6-4.7\",\n" +
                "      \"cleavage\": \"2 poor\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide13.jpg\",\n" +
                "      \"imageName\": \"Slide13\",\n" +
                "      \"title\": \"Augite\",\n" +
                "      \"chemistry\": \"Ca (Mg, Fe) Si_2 O_6 \",\n" +
                "      \"classification\": \"inosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5.5-6.5\",\n" +
                "      \"specific_gravity\": \"3.2-3.6\",\n" +
                "      \"cleavage\": \"2 good\",\n" +
                "      \"crustal_abundance\": \"high\",\n" +
                "      \"economic_value\": \"trivial\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide14.jpg\",\n" +
                "      \"imageName\": \"Slide14\",\n" +
                "      \"title\": \"Orthopyroxene\",\n" +
                "      \"chemistry\": \"(Mg, Fe)_2 Si_2 O_6 \",\n" +
                "      \"classification\": \"inosilicate\",\n" +
                "      \"crystal_system\": \"orthorhombic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"mantle\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5-6\",\n" +
                "      \"specific_gravity\": \"3.2-3.9\",\n" +
                "      \"cleavage\": \"2 good\",\n" +
                "      \"crustal_abundance\": \"high\",\n" +
                "      \"economic_value\": \"trivial\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide15.jpg\",\n" +
                "      \"imageName\": \"Slide15\",\n" +
                "      \"title\": \"Chlorite\",\n" +
                "      \"chemistry\": \"(Mg, Fe)_5 Al_2 Si_3 O_10 (OH)_8\",\n" +
                "      \"classification\": \"phyllosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"2-3\",\n" +
                "      \"specific_gravity\": \"2.6-3.3\",\n" +
                "      \"cleavage\": \"1 perfect\",\n" +
                "      \"crustal_abundance\": \"moderate\",\n" +
                "      \"economic_value\": \"low\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide16.jpg\",\n" +
                "      \"imageName\": \"Slide16\",\n" +
                "      \"title\": \"Antigorite\",\n" +
                "      \"chemistry\": \"(Mg, Fe)_3 Si_2 O_5 (OH)_4\",\n" +
                "      \"classification\": \"phyllosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"mantle\"\n" +
                "      ],\n" +
                "      \"hardness\": \"3.5-4\",\n" +
                "      \"specific_gravity\": \"2.6\",\n" +
                "      \"cleavage\": \"1 perfect\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"low\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide17.jpg\",\n" +
                "      \"imageName\": \"Slide17\",\n" +
                "      \"title\": \"Talc\",\n" +
                "      \"chemistry\": \"Mg_3 Si_4 O_10 (OH)_2\",\n" +
                "      \"classification\": \"phyllosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"1\",\n" +
                "      \"specific_gravity\": \"2.6-2.8\",\n" +
                "      \"cleavage\": \"1 perfect\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide18.jpg\",\n" +
                "      \"imageName\": \"Slide18\",\n" +
                "      \"title\": \"Kaolinite\",\n" +
                "      \"chemistry\": \"Al_2 Si_2 O_5 (OH)_4\",\n" +
                "      \"classification\": \"phyllosilicate\",\n" +
                "      \"crystal_system\": \"triclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"1.5-2.5\",\n" +
                "      \"specific_gravity\": \"2.6-2.7\",\n" +
                "      \"cleavage\": \"1 perfect\",\n" +
                "      \"crustal_abundance\": \"moderate\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide19.jpg\",\n" +
                "      \"imageName\": \"Slide19\",\n" +
                "      \"title\": \"Andalusite\",\n" +
                "      \"chemistry\": \"Al_2 Si O_5\",\n" +
                "      \"classification\": \"nesosilicate\",\n" +
                "      \"crystal_system\": \"orthorhombic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"6.5-7\",\n" +
                "      \"specific_gravity\": \"3.15\",\n" +
                "      \"cleavage\": \"2 good\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide20.jpg\",\n" +
                "      \"imageName\": \"Slide20\",\n" +
                "      \"title\": \"Kyanite\",\n" +
                "      \"chemistry\": \"Al_2 Si O_5\",\n" +
                "      \"classification\": \"nesosilicate\",\n" +
                "      \"crystal_system\": \"triclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5.5-7\",\n" +
                "      \"specific_gravity\": \"3.5-3.7\",\n" +
                "      \"cleavage\": \"1 perfect, 1 good\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide21.jpg\",\n" +
                "      \"imageName\": \"Slide21\",\n" +
                "      \"title\": \"Sillimanite\",\n" +
                "      \"chemistry\": \"Al_2 Si O_5\",\n" +
                "      \"classification\": \"nesosilicate\",\n" +
                "      \"crystal_system\": \"orthorhombic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"6.5-7.5\",\n" +
                "      \"specific_gravity\": \"3.25\",\n" +
                "      \"cleavage\": \"1 perfect, 1 good\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"low\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide22.jpg\",\n" +
                "      \"imageName\": \"Slide22\",\n" +
                "      \"title\": \"Staurolite\",\n" +
                "      \"chemistry\": \"(Fe, Mg)_2 Al_9 Si_4 O_22 (OH)_2\",\n" +
                "      \"classification\": \"nesosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"7\",\n" +
                "      \"specific_gravity\": \"3.7-3.8\",\n" +
                "      \"cleavage\": \"1 good\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"low\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide23.jpg\",\n" +
                "      \"imageName\": \"Slide23\",\n" +
                "      \"title\": \"Epidote\",\n" +
                "      \"chemistry\": \"Ca_2 (Al, Fe)_3 Si_3 O_12 (OH)\",\n" +
                "      \"classification\": \"sorosilicate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"6 - 6.5\",\n" +
                "      \"specific_gravity\": \"3.2 - 3.5\",\n" +
                "      \"cleavage\": \"1 perfect\",\n" +
                "      \"crustal_abundance\": \"moderate\",\n" +
                "      \"economic_value\": \"trivial\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide24.jpg\",\n" +
                "      \"imageName\": \"Slide24\",\n" +
                "      \"title\": \"Tourmaline\",\n" +
                "      \"chemistry\": \"Na (Mg, Fe)_3 Al_6 B_3 Si_6 O_27 (OH)_4\",\n" +
                "      \"classification\": \"cyclosilicate\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"7 - 7.5\",\n" +
                "      \"specific_gravity\": \"3.0 - 3.2\",\n" +
                "      \"cleavage\": \"2 poor\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide25.jpg\",\n" +
                "      \"imageName\": \"Slide25\",\n" +
                "      \"title\": \"Topaz\",\n" +
                "      \"chemistry\": \"Al_2 Si O_4 (F, OH)_2\",\n" +
                "      \"classification\": \"nesosilicate\",\n" +
                "      \"crystal_system\": \"orthorhombic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"8\",\n" +
                "      \"specific_gravity\": \"3.5 - 3.6\",\n" +
                "      \"cleavage\": \"1 perfect\",\n" +
                "      \"crustal_abundance\": \"ultratrace\",\n" +
                "      \"economic_value\": \"low\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide26.jpg\",\n" +
                "      \"imageName\": \"Slide26\",\n" +
                "      \"title\": \"Beryl\",\n" +
                "      \"chemistry\": \"Be_3 Al_2 Si_6 O_18\",\n" +
                "      \"classification\": \"cyclosilicate\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"7.5 - 8\",\n" +
                "      \"specific_gravity\": \"2.6 - 2.9\",\n" +
                "      \"cleavage\": \"1 poor\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide27.jpg\",\n" +
                "      \"imageName\": \"Slide27\",\n" +
                "      \"title\": \"Pyrite\",\n" +
                "      \"chemistry\": \"Fe S_2\",\n" +
                "      \"classification\": \"sulfide\",\n" +
                "      \"crystal_system\": \"isometric\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"6 - 6.5\",\n" +
                "      \"specific_gravity\": \"5\",\n" +
                "      \"cleavage\": \"2 poor\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide28.jpg\",\n" +
                "      \"imageName\": \"Slide28\",\n" +
                "      \"title\": \"Pyrrhotite\",\n" +
                "      \"chemistry\": \"Fe_{1-x} S\",\n" +
                "      \"classification\": \"sulfide\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"3.5 - 4.5\",\n" +
                "      \"specific_gravity\": \"4.6\",\n" +
                "      \"cleavage\": \"none\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide29.jpg\",\n" +
                "      \"imageName\": \"Slide29\",\n" +
                "      \"title\": \"Chalcopyrite\",\n" +
                "      \"chemistry\": \"Cu Fe S_2\",\n" +
                "      \"classification\": \"sulfide\",\n" +
                "      \"crystal_system\": \"tetragonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"3.5 - 4\",\n" +
                "      \"specific_gravity\": \"4.1 - 4.3\",\n" +
                "      \"cleavage\": \"2 poor\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"very high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide30.jpg\",\n" +
                "      \"imageName\": \"Slide30\",\n" +
                "      \"title\": \"Galena\",\n" +
                "      \"chemistry\": \"Pb S\",\n" +
                "      \"classification\": \"sulfide\",\n" +
                "      \"crystal_system\": \"isometric\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"2.5\",\n" +
                "      \"specific_gravity\": \"7.5 - 7.6\",\n" +
                "      \"cleavage\": \"3 perfect\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide31.jpg\",\n" +
                "      \"imageName\": \"Slide31\",\n" +
                "      \"title\": \"Sphalerite\",\n" +
                "      \"chemistry\": \"(Zn, Fe) S\",\n" +
                "      \"classification\": \"sulfide\",\n" +
                "      \"crystal_system\": \"isometric\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"3.5 - 4\",\n" +
                "      \"specific_gravity\": \"3.9 - 4.1\",\n" +
                "      \"cleavage\": \"6 perfect\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide32.jpg\",\n" +
                "      \"imageName\": \"Slide32\",\n" +
                "      \"title\": \"Molybdenite\",\n" +
                "      \"chemistry\": \"Mo S_2\",\n" +
                "      \"classification\": \"sulfide\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"1 - 1.5\",\n" +
                "      \"specific_gravity\": \"4.7\",\n" +
                "      \"cleavage\": \"1 perfect\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide33.jpg\",\n" +
                "      \"imageName\": \"Slide33\",\n" +
                "      \"title\": \"Gold\",\n" +
                "      \"chemistry\": \"Au\",\n" +
                "      \"classification\": \"native element\",\n" +
                "      \"crystal_system\": \"isometric\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"2.5 - 3\",\n" +
                "      \"specific_gravity\": \"19.3\",\n" +
                "      \"cleavage\": \"none\",\n" +
                "      \"crustal_abundance\": \"ultratrace\",\n" +
                "      \"economic_value\": \"I'm rich!\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide34.jpg\",\n" +
                "      \"imageName\": \"Slide34\",\n" +
                "      \"title\": \"Diamond\",\n" +
                "      \"chemistry\": \"C\",\n" +
                "      \"classification\": \"native element\",\n" +
                "      \"crystal_system\": \"isometric\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"10\",\n" +
                "      \"specific_gravity\": \"3.5\",\n" +
                "      \"cleavage\": \"4 perfect\",\n" +
                "      \"crustal_abundance\": \"ultratrace\",\n" +
                "      \"economic_value\": \"I'm rich!\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide35.jpg\",\n" +
                "      \"imageName\": \"Slide35\",\n" +
                "      \"title\": \"Graphite\",\n" +
                "      \"chemistry\": \"C\",\n" +
                "      \"classification\": \"native element\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"1 - 2\",\n" +
                "      \"specific_gravity\": \"2.2\",\n" +
                "      \"cleavage\": \"1 perfect\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide36.jpg\",\n" +
                "      \"imageName\": \"Slide36\",\n" +
                "      \"title\": \"Halite\",\n" +
                "      \"chemistry\": \"Na Cl\",\n" +
                "      \"classification\": \"halide\",\n" +
                "      \"crystal_system\": \"isometric\",\n" +
                "      \"occurrence\": [\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"2.5\",\n" +
                "      \"specific_gravity\": \"2.2\",\n" +
                "      \"cleavage\": \"3 perfect\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide37.jpg\",\n" +
                "      \"imageName\": \"Slide37\",\n" +
                "      \"title\": \"Fluorite\",\n" +
                "      \"chemistry\": \"Ca F_2\",\n" +
                "      \"classification\": \"halide\",\n" +
                "      \"crystal_system\": \"isometric\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\"\n" +
                "      ],\n" +
                "      \"hardness\": \"4\",\n" +
                "      \"specific_gravity\": \"3.2\",\n" +
                "      \"cleavage\": \"4 perfect\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide38.jpg\",\n" +
                "      \"imageName\": \"Slide38\",\n" +
                "      \"title\": \"Gypsum\",\n" +
                "      \"chemistry\": \"Ca S O_4 (H_2 O)_2\",\n" +
                "      \"classification\": \"sulfate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"2\",\n" +
                "      \"specific_gravity\": \"2.3\",\n" +
                "      \"cleavage\": \"1 perfect, 2 good\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide39.jpg\",\n" +
                "      \"imageName\": \"Slide39\",\n" +
                "      \"title\": \"Barite\",\n" +
                "      \"chemistry\": \"Ba S O_4\",\n" +
                "      \"classification\": \"sulfate\",\n" +
                "      \"crystal_system\": \"orthorhombic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"3 - 3.5\",\n" +
                "      \"specific_gravity\": \"4.5\",\n" +
                "      \"cleavage\": \"2 perfect, 1 good\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide40.jpg\",\n" +
                "      \"imageName\": \"Slide40\",\n" +
                "      \"title\": \"Apatite\",\n" +
                "      \"chemistry\": \"Ca_5 (P O_4)_3 (OH, F, Cl)\",\n" +
                "      \"classification\": \"phosphate\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5\",\n" +
                "      \"specific_gravity\": \"3.1 - 3.2\",\n" +
                "      \"cleavage\": \"2 poor\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide41.jpg\",\n" +
                "      \"imageName\": \"Slide41\",\n" +
                "      \"title\": \"Monazite\",\n" +
                "      \"chemistry\": \"(La, Ce, Nd) P O_4 \",\n" +
                "      \"classification\": \"phosphate\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5\",\n" +
                "      \"specific_gravity\": \"5.0 - 5.3\",\n" +
                "      \"cleavage\": \"1 good, 1 poor\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide42.jpg\",\n" +
                "      \"imageName\": \"Slide42\",\n" +
                "      \"title\": \"Calcite\",\n" +
                "      \"chemistry\": \"Ca C O_3\",\n" +
                "      \"classification\": \"carbonate\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"3\",\n" +
                "      \"specific_gravity\": \"2.7\",\n" +
                "      \"cleavage\": \"3 perfect\",\n" +
                "      \"crustal_abundance\": \"moderate\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide43.jpg\",\n" +
                "      \"imageName\": \"Slide43\",\n" +
                "      \"title\": \"Dolomite\",\n" +
                "      \"chemistry\": \"Ca Mg (C O_3)_2\",\n" +
                "      \"classification\": \"carbonate\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"3.5 - 4\",\n" +
                "      \"specific_gravity\": \"2.9\",\n" +
                "      \"cleavage\": \"3 perfect\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"low\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide44.jpg\",\n" +
                "      \"imageName\": \"Slide44\",\n" +
                "      \"title\": \"Magnesite\",\n" +
                "      \"chemistry\": \"Mg C O_3\",\n" +
                "      \"classification\": \"carbonate\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"4\",\n" +
                "      \"specific_gravity\": \"3.0\",\n" +
                "      \"cleavage\": \"3 perfect\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide45.jpg\",\n" +
                "      \"imageName\": \"Slide45\",\n" +
                "      \"title\": \"Siderite\",\n" +
                "      \"chemistry\": \"Fe C O_3\",\n" +
                "      \"classification\": \"carbonate\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"4 - 4.5\",\n" +
                "      \"specific_gravity\": \"4\",\n" +
                "      \"cleavage\": \"3 perfect\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide46.jpg\",\n" +
                "      \"imageName\": \"Slide46\",\n" +
                "      \"title\": \"Magnetite\",\n" +
                "      \"chemistry\": \"Fe_3 O_4\",\n" +
                "      \"classification\": \"oxide (spinel)\",\n" +
                "      \"crystal_system\": \"isometric\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5.5 - 6\",\n" +
                "      \"specific_gravity\": \"5.2\",\n" +
                "      \"cleavage\": \"none\",\n" +
                "      \"crustal_abundance\": \"moderate\",\n" +
                "      \"economic_value\": \"very high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide47.jpg\",\n" +
                "      \"imageName\": \"Slide47\",\n" +
                "      \"title\": \"Hematite\",\n" +
                "      \"chemistry\": \"Fe_2 O_3\",\n" +
                "      \"classification\": \"oxide\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5 - 6\",\n" +
                "      \"specific_gravity\": \"5.3\",\n" +
                "      \"cleavage\": \"none\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide48.jpg\",\n" +
                "      \"imageName\": \"Slide48\",\n" +
                "      \"title\": \"Chromite\",\n" +
                "      \"chemistry\": \"(Fe, Mg) Cr_2 O_4\",\n" +
                "      \"classification\": \"oxide (spinel)\",\n" +
                "      \"crystal_system\": \"isometric\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5.5\",\n" +
                "      \"specific_gravity\": \"4.5 - 5.1\",\n" +
                "      \"cleavage\": \"none\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide49.jpg\",\n" +
                "      \"imageName\": \"Slide49\",\n" +
                "      \"title\": \"Ilmenite\",\n" +
                "      \"chemistry\": \"Ti Fe O_3\",\n" +
                "      \"classification\": \"oxide\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5 - 6\",\n" +
                "      \"specific_gravity\": \"4.7 - 4.8\",\n" +
                "      \"cleavage\": \"none\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide50.jpg\",\n" +
                "      \"imageName\": \"Slide50\",\n" +
                "      \"title\": \"Rutile\",\n" +
                "      \"chemistry\": \"Ti O_2\",\n" +
                "      \"classification\": \"oxide\",\n" +
                "      \"crystal_system\": \"tetragonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"6 - 6.5\",\n" +
                "      \"specific_gravity\": \"4.3\",\n" +
                "      \"cleavage\": \"2 good\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide51.jpg\",\n" +
                "      \"imageName\": \"Slide51\",\n" +
                "      \"title\": \"Corundum\",\n" +
                "      \"chemistry\": \"Al_2 O_3\",\n" +
                "      \"classification\": \"oxide\",\n" +
                "      \"crystal_system\": \"hexagonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"9\",\n" +
                "      \"specific_gravity\": \"4.0\",\n" +
                "      \"cleavage\": \"none\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide52.jpg\",\n" +
                "      \"imageName\": \"Slide52\",\n" +
                "      \"title\": \"Cassiterite\",\n" +
                "      \"chemistry\": \"Sn O_2\",\n" +
                "      \"classification\": \"oxide\",\n" +
                "      \"crystal_system\": \"tetragonal\",\n" +
                "      \"occurrence\": [\n" +
                "        \"igneous\",\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"6 - 7\",\n" +
                "      \"specific_gravity\": \"6.9 - 7.1\",\n" +
                "      \"cleavage\": \"1 good, 1 poor\",\n" +
                "      \"crustal_abundance\": \"trace\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide53.jpg\",\n" +
                "      \"imageName\": \"Slide53\",\n" +
                "      \"title\": \"Gibbsite\",\n" +
                "      \"chemistry\": \"Al (O H)_3\",\n" +
                "      \"classification\": \"hydroxide\",\n" +
                "      \"crystal_system\": \"monoclinic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"metamorphic\",\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"2.5 - 3.5\",\n" +
                "      \"specific_gravity\": \"2.4\",\n" +
                "      \"cleavage\": \"1 perfect\",\n" +
                "      \"crustal_abundance\": \"low\",\n" +
                "      \"economic_value\": \"high\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide54.jpg\",\n" +
                "      \"imageName\": \"Slide54\",\n" +
                "      \"title\": \"Goethite\",\n" +
                "      \"chemistry\": \"Fe O (OH)\",\n" +
                "      \"classification\": \"hydroxide\",\n" +
                "      \"crystal_system\": \"orthorhombic\",\n" +
                "      \"occurrence\": [\n" +
                "        \"sedimentary\"\n" +
                "      ],\n" +
                "      \"hardness\": \"5 - 5.5\",\n" +
                "      \"specific_gravity\": \"4.3\",\n" +
                "      \"cleavage\": \"1 perfect, 1 good\",\n" +
                "      \"crustal_abundance\": \"moderate\",\n" +
                "      \"economic_value\": \"moderate\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide55.jpg\",\n" +
                "      \"imageName\": \"Slide55\",\n" +
                "      \"title\": \"The Miner\",\n" +
                "      \"subtitle\": \"Economic value\",\n" +
                "      \"categories\": [\n" +
                "        \"Economic value\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide56.jpg\",\n" +
                "      \"imageName\": \"Slide56\",\n" +
                "      \"title\": \"The Petrologist\",\n" +
                "      \"subtitle\": \"Crustal abundance\",\n" +
                "      \"categories\": [\n" +
                "        \"Crustal abundance\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide57.jpg\",\n" +
                "      \"imageName\": \"Slide57\",\n" +
                "      \"title\": \"The Gemmologist\",\n" +
                "      \"subtitle\": \"Hardness\",\n" +
                "      \"categories\": [\n" +
                "        \"Hardness\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide58.jpg\",\n" +
                "      \"imageName\": \"Slide58\",\n" +
                "      \"title\": \"The Mineralogist\",\n" +
                "      \"subtitle\": \"Cleavage\",\n" +
                "      \"categories\": [\n" +
                "        \"Cleavage\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide59.jpg\",\n" +
                "      \"imageName\": \"Slide59\",\n" +
                "      \"title\": \"The Geophysicist\",\n" +
                "      \"subtitle\": \"Specific gravity\",\n" +
                "      \"categories\": [\n" +
                "        \"Specific gravity\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"fileName\": \"Slide60.jpg\",\n" +
                "      \"imageName\": \"Slide60\",\n" +
                "      \"title\": \"The Geologist\",\n" +
                "      \"subtitle\": \"Change to trumps category of your choice\",\n" +
                "      \"categories\": [\n" +
                "        \"Cleavage\",\n" +
                "        \"Crustal abundance\",\n" +
                "        \"Economic value\",\n" +
                "        \"Hardness\",\n" +
                "        \"Specific gravity\"\n" +
                "      ]\n" +
                "    }\n" +
                "  ]\n" +
                "}";

                //TODO is this even a wrapper?
        @Override
        public JsonReader getReader() {
            return new JsonReader(new StringReader(jsonText));
        }
    }
}
