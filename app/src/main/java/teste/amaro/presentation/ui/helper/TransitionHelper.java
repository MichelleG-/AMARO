package teste.amaro.presentation.ui.helper;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.view.View;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TransitionHelper
{
    /**
     * Create the transition participants required during a activity transition while
     * avoiding glitches with the system UI.
     *
     * @param activity The activity used as start for the transition.
     * @param includeStatusBar If false, the status bar will not be added as the transition
     *        participant.
     * @return All transition participants.
     */
    public static Pair<View, String>[] createSafeTransitionParticipants(@NonNull Activity activity,
                                                                        boolean includeStatusBar, @Nullable Pair... otherParticipants)
    {
        View decor = activity.getWindow().getDecorView();
        View statusBar = null;

        if (includeStatusBar)
        {
            statusBar = decor.findViewById(android.R.id.statusBarBackground);
        }

        View navBar = decor.findViewById(android.R.id.navigationBarBackground);
        List<Pair> participants = new ArrayList<>(3);

        addNonNullViewToTransitionParticipants(statusBar, participants);
        addNonNullViewToTransitionParticipants(navBar, participants);

        if (otherParticipants != null && !(otherParticipants.length == 1 && otherParticipants[0] == null))
        {
            participants.addAll(Arrays.asList(otherParticipants));
        }

        return participants.toArray(new Pair[participants.size()]);
    }

    @SuppressLint("NewApi")
    private static void addNonNullViewToTransitionParticipants(View view, List<Pair> participants)
    {
        if (view == null)
        {
            return;
        }

        participants.add(new Pair<>(view, view.getTransitionName()));
    }
}
