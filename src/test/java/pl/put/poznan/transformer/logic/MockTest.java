package pl.put.poznan.transformer.logic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MockTest {

    @Test
    void testTransformationMock1(){
        InterfaceTextTransformer mockObject = mock(InterfaceTextTransformer.class);
        when(mockObject.getTransformation("np.")).thenReturn("na przykład");
        String result = mockObject.getTransformation("np.");
        verify(mockObject).getTransformation("np.");

        assertEquals("na przykład", result);
    }

    @Test
    void testTransformationMock2(){
        InterfaceTextTransformer mockObject = mock(InterfaceTextTransformer.class);
        when(mockObject.getTransformation("Lubię samochody, motory, ITD.")).thenReturn("Lubię samochody, motory, I Tak Dalej");
        String result = mockObject.getTransformation("Lubię samochody, motory, ITD.");
        verify(mockObject).getTransformation("Lubię samochody, motory, ITD.");

        assertEquals("Lubię samochody, motory, I Tak Dalej", result);
    }

    @Test
    void testTransformationMock3(){
        InterfaceTextTransformer mockObject = mock(InterfaceTextTransformer.class);
        when(mockObject.getTransformation("Prof. Nowak miał dzisiaj interesujący wykład")).thenReturn("Profesor Nowak miał dzisiaj interesujący wykład");
        String result = mockObject.getTransformation("Prof. Nowak miał dzisiaj interesujący wykład");
        verify(mockObject).getTransformation("Prof. Nowak miał dzisiaj interesujący wykład");

        assertEquals("Profesor Nowak miał dzisiaj interesujący wykład", result);
    }

    @Test
    void testTransformationMock4(){
        InterfaceTextTransformer mockObject = mock(InterfaceTextTransformer.class);
        when(mockObject.getTransformation("na przykład")).thenReturn("np.");
        String result = mockObject.getTransformation("na przykład");
        verify(mockObject).getTransformation("na przykład");

        assertEquals("np.", result);
    }

    @Test
    void testTransformationMock5(){
        InterfaceTextTransformer mockObject = mock(InterfaceTextTransformer.class);
        when(mockObject.getTransformation("Lubię Między Innymi lody")).thenReturn("Lubię M.In. lody");
        String result = mockObject.getTransformation("Lubię Między Innymi lody");
        verify(mockObject).getTransformation("Lubię Między Innymi lody");

        assertEquals("Lubię M.In. lody", result);
    }

    @Test
    void testTransformationMock6(){
        InterfaceTextTransformer mockObject = mock(InterfaceTextTransformer.class);
        when(mockObject.getTransformation("Dziś na OBIAD są NaLeśńiKi")).thenReturn("dziś na obiad są naleśniki");
        String result = mockObject.getTransformation("Dziś na OBIAD są NaLeśńiKi");
        verify(mockObject).getTransformation("Dziś na OBIAD są NaLeśńiKi");

        assertEquals("dziś na obiad są naleśniki", result);
    }

    @Test
    void testTransformationMock7(){
        InterfaceTextTransformer mockObject = mock(InterfaceTextTransformer.class);
        when(mockObject.getTransformation("Dziś na OBIAD są NaLeśńiKi")).thenReturn("DZIŚ NA OBIAD SĄ NALEŚNIKI");
        String result = mockObject.getTransformation("Dziś na OBIAD są NaLeśńiKi");
        verify(mockObject).getTransformation("Dziś na OBIAD są NaLeśńiKi");

        assertEquals("DZIŚ NA OBIAD SĄ NALEŚNIKI", result);
    }

    @Test
    void testTransformationMock8(){
        InterfaceTextTransformer mockObject = mock(InterfaceTextTransformer.class);
        when(mockObject.getTransformation("Dziś na OBIAD są NaLeśniKi")).thenReturn("Dziś Na Obiad Są Naleśniki");
        String result = mockObject.getTransformation("Dziś na OBIAD są NaLeśniKi");
        verify(mockObject).getTransformation("Dziś na OBIAD są NaLeśniKi");

        assertEquals("Dziś Na Obiad Są Naleśniki", result);
    }

    @Test
    void testTransformationMock9(){
        InterfaceTextTransformer mockObject = mock(InterfaceTextTransformer.class);
        when(mockObject.getTransformation("Dziś na OBIAD są NaLeśniKi")).thenReturn("Dzis na OBIAD sa NaLesniKi");
        String result = mockObject.getTransformation("Dziś na OBIAD są NaLeśniKi");
        verify(mockObject).getTransformation("Dziś na OBIAD są NaLeśniKi");

        assertEquals("Dzis na OBIAD sa NaLesniKi", result);
    }

    @Test
    void testTransformationMock10(){
        InterfaceTextTransformer mockObject = mock(InterfaceTextTransformer.class);
        when(mockObject.getTransformation("Dziś na na OBIAD OBIAD są NaLeśniKi")).thenReturn("Dzis na OBIAD sa NaLesniKi");
        String result = mockObject.getTransformation("Dziś na na OBIAD OBIAD są NaLeśniKi");
        verify(mockObject).getTransformation("Dziś na na OBIAD OBIAD są NaLeśniKi");

        assertEquals("Dzis na OBIAD sa NaLesniKi", result);
    }
}
