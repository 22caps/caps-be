package com.syu.capsbe.domain.problem.application;

import com.syu.capsbe.domain.problem.ProblemRepository;
import com.syu.capsbe.domain.problem.ProblemType;
import com.syu.capsbe.domain.problem.dto.request.ProblemRequestDto;
import com.syu.capsbe.domain.problem.dto.response.ProblemResponseDto;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProblemServiceImpl implements ProblemService {

    private final ProblemRepository problemRepository;

    @Override
    public List<ProblemResponseDto> getProblemsByProblemType(ProblemRequestDto problemRequestDto) {
        // dto에서 type을 enum 값으로 맞게 변경
        ProblemType problemType = ProblemType.valueOf(problemRequestDto.getProblemType());

        // dto에서 count를 가져와서 해당 type의 문제를 count만큼 가져옴
        return problemRepository.getProblemTypeIsWord(problemType,
                        problemRequestDto.getProblemCount())
                .stream()
                .map(ProblemResponseDto::of)
                .collect(Collectors.toList());
    }
}
