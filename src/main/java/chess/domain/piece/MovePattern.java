package chess.domain.piece;

import chess.domain.player.Direction;

import java.util.Arrays;
import java.util.List;

import static chess.domain.player.Direction.EAST;
import static chess.domain.player.Direction.NORTH;
import static chess.domain.player.Direction.NORTH_EAST;
import static chess.domain.player.Direction.NORTH_EAST_EAST;
import static chess.domain.player.Direction.NORTH_EAST_NORTH;
import static chess.domain.player.Direction.NORTH_WEST;
import static chess.domain.player.Direction.NORTH_WEST_NORTH;
import static chess.domain.player.Direction.NORTH_WEST_WEST;
import static chess.domain.player.Direction.SOUTH;
import static chess.domain.player.Direction.SOUTH_EAST;
import static chess.domain.player.Direction.SOUTH_EAST_EAST;
import static chess.domain.player.Direction.SOUTH_EAST_SOUTH;
import static chess.domain.player.Direction.SOUTH_WEST;
import static chess.domain.player.Direction.SOUTH_WEST_SOUTH;
import static chess.domain.player.Direction.SOUTH_WEST_WEST;
import static chess.domain.player.Direction.WEST;

public enum MovePattern {
    CARDINAL_DIRECTIONS(Arrays.asList(NORTH, SOUTH, WEST, EAST)),

    DIAGONAL_DIRECTIONS(Arrays.asList(NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST)),

    ALL_DIRECTIONS(Arrays.asList(NORTH, SOUTH, WEST, EAST, NORTH_EAST, NORTH_WEST, SOUTH_EAST, SOUTH_WEST)),

    WHITE_PAWN_DIRECTIONS(Arrays.asList(NORTH_EAST, NORTH_WEST, NORTH)),

    WHITE_PAWN_ATTACK_DIRECTIONS(Arrays.asList(NORTH_EAST, NORTH_WEST)),

    BLACK_PAWN_DIRECTIONS(Arrays.asList(SOUTH_EAST, SOUTH_WEST, SOUTH)),

    BLACK_PAWN_ATTACK_DIRECTIONS(Arrays.asList(SOUTH_EAST, SOUTH_WEST)),

    KNIGHT_DIRECTIONS(Arrays.asList(NORTH_EAST_NORTH, NORTH_EAST_EAST, NORTH_WEST_WEST, NORTH_WEST_NORTH,
            SOUTH_EAST_EAST, SOUTH_EAST_SOUTH, SOUTH_WEST_SOUTH, SOUTH_WEST_WEST));

    private final List<Direction> directions;

    MovePattern(final List<Direction> directions) {
        this.directions = directions;
    }

    public static MovePattern findPawnMovePattern(final Color color) {
        if (color.isWhite()) {
            return WHITE_PAWN_DIRECTIONS;
        }

        return BLACK_PAWN_DIRECTIONS;
    }

    public Direction findDirection(int fileGap, int rankGap) {
        return this.directions.stream()
                .filter(direction -> direction.matches(fileGap, rankGap))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("매칭되는 방향이 없습니다."));
    }

    public List<Direction> getDirections() {
        return directions;
    }
}