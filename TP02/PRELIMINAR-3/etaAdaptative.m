function [ curError, weights, eta, k] = etaAdaptative( lastError, curError, lastWeights, allWeights, etaInc, etaDec, curEta, curK, K )
%ETAADAPTATIVE This function applys the adaptative eta module.

    error = curError - lastError;
    if error > 0 
       weights = lastWeights;
       eta = curEta - etaDec * curEta;
       k = 0;
    elseif error <= 0
        if curK < K
            k = curK + 1;
            eta = curEta;
        else
            eta = curEta + etaInc;
            k = 0;
        end
        weights = allWeights;
    end
end

