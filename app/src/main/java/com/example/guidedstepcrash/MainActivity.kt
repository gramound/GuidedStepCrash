package com.example.guidedstepcrash

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.leanback.app.GuidedStepSupportFragment
import androidx.leanback.widget.GuidanceStylist
import androidx.leanback.widget.GuidedAction

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            GuidedStepSupportFragment.addAsRoot(this, FirstStepFragment(), android.R.id.content)
        }
    }
    class FirstStepFragment : GuidedStepSupportFragment() {
        override fun onCreateGuidance(savedInstanceState: Bundle?): GuidanceStylist.Guidance {
            return GuidanceStylist.Guidance("Try Continue-Back-Continue", null, null, null)
        }
        override fun onCreateActions(actions: MutableList<GuidedAction>, savedInstanceState: Bundle?) {
            super.onCreateActions(actions, savedInstanceState)
            actions.add(GuidedAction.Builder(requireContext()).id(GuidedAction.ACTION_ID_CONTINUE).title("Continue").hasNext(true).build()
            )
        }
        override fun onGuidedActionClicked(action: GuidedAction) {
            add(parentFragmentManager, SecondStepFragment())
        }
    }
    class SecondStepFragment : GuidedStepSupportFragment() {
        override fun onCreateGuidance(savedInstanceState: Bundle?): GuidanceStylist.Guidance {
            return GuidanceStylist.Guidance("Second step", null, null, null)
        }
        override fun onCreateActions(actions: MutableList<GuidedAction>, savedInstanceState: Bundle?) {
            super.onCreateActions(actions, savedInstanceState)
            actions.add(GuidedAction.Builder(requireContext()).id(GuidedAction.ACTION_ID_CANCEL).title("Press BACK now").build())
        }
    }
}