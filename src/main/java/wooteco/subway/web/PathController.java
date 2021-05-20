package wooteco.subway.web;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import wooteco.subway.service.PathService;
import wooteco.subway.web.dto.PathRequest;
import wooteco.subway.web.dto.PathResponse;

@RequestMapping("/api/paths")
@RestController
public class PathController {

    private final PathService pathService;

    public PathController(PathService pathService) {
        this.pathService = pathService;
    }

    @GetMapping
    public ResponseEntity<PathResponse> shortestPath(PathRequest pathRequest) {
        return ResponseEntity.ok(pathService.findShortestPaths(pathRequest.getSource(), pathRequest.getTarget()));
    }
}
