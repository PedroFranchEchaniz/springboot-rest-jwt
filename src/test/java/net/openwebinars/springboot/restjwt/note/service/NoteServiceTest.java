package net.openwebinars.springboot.restjwt.note.service;

import net.openwebinars.springboot.restjwt.dto.GetNoteDto;
import net.openwebinars.springboot.restjwt.dto.NotesGroupedByTagsDto;
import net.openwebinars.springboot.restjwt.note.model.Note;
import net.openwebinars.springboot.restjwt.note.repo.NoteRepository;
import net.openwebinars.springboot.restjwt.user.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class NoteServiceTest {

    @InjectMocks
    NoteService noteService;

    @Mock
    NoteRepository noteRepository;
    @Test
    void notesGroupedByTagsDtoList() {

        User user = User.builder()
                .id(UUID.randomUUID())
                .build();

        Note note = Note.builder()
                .id(1L)
                .author(user.getId().toString())
                .title("Repasar Testing")
                .tags(List.of("Estudio", "Importante"))
                .build();

        Note note2 = Note.builder()
                .id(2L)
                .title("Terminar flutter")
                .author(user.getId().toString())
                .tags(List.of("Estudio"))
                .build();

        Note note3 = Note.builder()
                .id(3L)
                .title("Hacer la compra")
                .author(user.getId().toString())
                .tags(List.of("Importante"))
                .build();

        List<Note> listaNotas =List.of(note,note2,note3);

        Mockito.when(noteRepository.findByAuthor(user.getId().toString())).thenReturn(listaNotas);

        List<NotesGroupedByTagsDto> groupTags = List.of(
                new NotesGroupedByTagsDto("Importante", List.of(
                        GetNoteDto.of(note),
                        GetNoteDto.of(note3)
                )),
                new NotesGroupedByTagsDto("Estudio", List.of(
                        GetNoteDto.of(note),
                        GetNoteDto.of(note2)
                ))
        );

        List<NotesGroupedByTagsDto> reult = noteService.notesGroupedByTagsDtoList(user.getId().toString());

        Assertions.assertFalse(reult.isEmpty());
        Assertions.assertEquals(2, reult.size());
    }
}